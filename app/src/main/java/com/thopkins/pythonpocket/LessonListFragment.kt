package com.thopkins.pythonpocket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LessonListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LessonAdapter
    private lateinit var lessons: List<Lesson>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lesson_list, container, false)
        recyclerView = view.findViewById(R.id.lessonRecycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        lessons = LessonLoader.loadAll(requireContext())
        adapter = LessonAdapter(lessons) { lesson ->
            // open detail fragment
            val frag = LessonDetailFragment.newInstance(lesson.id)
            fragmentManager?.beginTransaction()
                ?.replace(R.id.container, frag)
                ?.addToBackStack(null)
                ?.commit()
        }
        recyclerView.adapter = adapter
        return view
    }
}
