package com.thopkins.pythonpocket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LessonAdapter(
    private val lessons: List<Lesson>,
    private val onClick: (Lesson) -> Unit
): RecyclerView.Adapter<LessonAdapter.VH>() {

    inner class VH(view: View): RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.lessonTitle)
        val subtitle: TextView = view.findViewById(R.id.lessonSubtitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val lesson = lessons[position]
        holder.title.text = lesson.title
        holder.subtitle.text = lesson.level
        holder.itemView.setOnClickListener { onClick(lesson) }
    }

    override fun getItemCount() = lessons.size
}
