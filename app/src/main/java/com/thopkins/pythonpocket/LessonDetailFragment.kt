package com.thopkins.pythonpocket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.chaquo.python.Python
import com.chaquo.python.PyObject

private const val ARG_ID = "lesson_id"

class LessonDetailFragment : Fragment() {

    private var lessonId: String? = null
    private var lesson: Lesson? = null

    companion object {
        fun newInstance(lessonId: String) = LessonDetailFragment().apply {
            arguments = Bundle().apply { putString(ARG_ID, lessonId) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { lessonId = it.getString(ARG_ID) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lesson_detail, container, false)
        val titleView = view.findViewById<TextView>(R.id.title)
        val textView = view.findViewById<TextView>(R.id.text)
        val editor = view.findViewById<EditText>(R.id.codeEditor)
        val runBtn = view.findViewById<Button>(R.id.runBtn)
        val output = view.findViewById<TextView>(R.id.output)

        lesson = lessonId?.let { LessonLoader.load(requireContext(), it) }
        lesson?.let {
            titleView.text = it.title
            textView.text = it.text
            editor.setText(it.starterCode ?: it.example ?: "")
        }

        runBtn.setOnClickListener {
            val code = editor.text.toString()
            // call Chaquopy runner
            try {
                val py = Python.getInstance()
                val runner = py.getModule("python_runner")
                val result = runner.callAttr("run_snippet", code)
                output.text = result.toString()
            } catch (e: Exception) {
                output.text = "Runtime error: ${e.message}"
            }
        }

        return view
    }
}
