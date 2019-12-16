package com.tigerhood.running.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tigerhood.running.entity.WorkoutDay
import androidx.recyclerview.widget.RecyclerView
import com.tigerhood.running.R
import kotlinx.android.synthetic.main.view_holder_day_selector.view.*


class DaySelectorAdapter(private var days: List<WorkoutDay> = listOf()) :
    RecyclerView.Adapter<DaySelectorAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val week: TextView? = itemView.day_selector_week
        val day: TextView? = itemView.day_selector_day
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout =
            if (viewType == 0) R.layout.view_holder_day_selector_selected else R.layout.view_holder_day_selector
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder((view))
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount() = days.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val workoutDay = days[position]

        holder.week?.text = "WEEK ${workoutDay.week}"
        holder.day?.text = "DAY ${workoutDay.day}"
    }

    fun updateDays(days: List<WorkoutDay>) {
        this.days = days
        notifyDataSetChanged()
    }
}
