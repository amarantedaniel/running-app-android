package com.tigerhood.running.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tigerhood.running.entity.WorkoutDay
import androidx.recyclerview.widget.RecyclerView
import com.tigerhood.running.R
import kotlinx.android.synthetic.main.view_holder_day_selector.view.*


class DaySelectorAdapter(private var days: List<WorkoutDay>) :
    RecyclerView.Adapter<DaySelectorAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView? = itemView.view_holder_title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_day_selector, parent, false)
        return ViewHolder((view))
    }

    override fun getItemCount() = days.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title?.text = days[position].description
    }
}
