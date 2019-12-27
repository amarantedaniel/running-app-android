package com.tigerhood.running.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tigerhood.running.R
import com.tigerhood.running.entity.WorkoutDay
import kotlinx.android.synthetic.main.view_holder_day_selector.view.*


class DaySelectorAdapter(
    private var listener: (WorkoutDay) -> Unit,
    private var days: List<WorkoutDay> = listOf(),
    private var selectedDay: WorkoutDay? = null
) :
    RecyclerView.Adapter<DaySelectorAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val week: TextView? = itemView.day_selector_week
        val day: TextView? = itemView.day_selector_day
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ViewHolder((view))
    }

    override fun getItemViewType(position: Int): Int {
        val day = days[position]
        return if (day == selectedDay) R.layout.view_holder_day_selector_selected else R.layout.view_holder_day_selector
    }

    override fun getItemCount() = days.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val workoutDay = days[position]
        holder.week?.text = holder.itemView.context.getString(R.string.week_number, workoutDay.week)
        holder.day?.text = holder.itemView.context.getString(R.string.day_number, workoutDay.day)
        holder.itemView.setOnClickListener { listener(workoutDay) }
    }

    fun updateDays(days: List<WorkoutDay>) {
        this.days = days
        notifyDataSetChanged()
    }

    fun updateSelectedIndex(day: WorkoutDay) {
        val previousIndex = days.indexOf(selectedDay)
        val currentIndex = days.indexOf(day)
        selectedDay = day
        notifyItemChanged(previousIndex)
        notifyItemChanged(currentIndex)
    }
}
