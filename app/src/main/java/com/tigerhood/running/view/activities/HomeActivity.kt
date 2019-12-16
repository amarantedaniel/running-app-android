package com.tigerhood.running.view.activities

import android.os.Bundle
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
        val days = listOf(
            WorkoutDay("", 1, 1, "Description 1"),
            WorkoutDay("", 1, 2, "Description 2"),
            WorkoutDay("", 1, 3, "Description 3"),
            WorkoutDay("", 2, 1, "Description 4"),
            WorkoutDay("", 2, 2, "Description 5"),
            WorkoutDay("", 2, 3, "Description 5"),
            WorkoutDay("", 3, 1, "Description 5"),
            WorkoutDay("", 3, 2, "Description 5"),
            WorkoutDay("", 3, 3, "Description 5")
        )

        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = DaySelectorAdapter(days)

        val dividerItemDecoration =
            DividerItemDecoration(recyclerView.context, LinearLayoutManager.HORIZONTAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
    }
}
