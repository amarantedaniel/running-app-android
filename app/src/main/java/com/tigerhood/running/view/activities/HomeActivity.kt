package com.tigerhood.running.view.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tigerhood.running.HomeContract
import com.tigerhood.running.R
import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.presenter.HomePresenter
import com.tigerhood.running.view.adapters.DaySelectorAdapter
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(), HomeContract.View {

    private var presenter: HomeContract.Presenter? = null
    private val recyclerView: RecyclerView by lazy { recycler_view_day_selector }
    private val descriptionView: TextView by lazy { description_text_view }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePresenter(this)
        setContentView(R.layout.activity_home)
        setupRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        presenter?.onViewCreated()
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        presenter = null
        super.onDestroy()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter =
            DaySelectorAdapter({ day -> presenter?.onDaySelected(day) })

        val dividerItemDecoration =
            DividerItemDecoration(recyclerView.context, LinearLayoutManager.HORIZONTAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun updateWorkoutDays(days: List<WorkoutDay>) {
        (recyclerView.adapter as DaySelectorAdapter).updateDays(days)
    }

    override fun updateSelectedDay(day: WorkoutDay) {
        (recyclerView.adapter as DaySelectorAdapter).updateSelectedIndex(day)
        descriptionView.text = day.description
    }
}
