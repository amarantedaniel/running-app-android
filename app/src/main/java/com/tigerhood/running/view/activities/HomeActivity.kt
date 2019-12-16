package com.tigerhood.running.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tigerhood.running.HomeContract
import com.tigerhood.running.R
import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.view.adapters.DaySelectorAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeContract.View {

    private val recyclerView: RecyclerView by lazy { recycler_view_day_selector }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val days = listOf(
            WorkoutDay("", 1, 2, "Description 1"),
            WorkoutDay("", 1, 2, "Description 2"),
            WorkoutDay("", 1, 2, "Description 3"),
            WorkoutDay("", 1, 2, "Description 4"),
            WorkoutDay("", 1, 2, "Description 5")
        )
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = DaySelectorAdapter(days)
    }
}
