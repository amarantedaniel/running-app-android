package com.tigerhood.running.view.fragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tigerhood.running.HomeContract
import com.tigerhood.running.R
import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.presenter.HomePresenter
import com.tigerhood.running.view.adapters.DaySelectorAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home), HomeContract.View {

    private var presenter: HomeContract.Presenter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        presenter = HomePresenter(this)
        presenter?.onViewCreated()
        startButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.navigateToWorkoutFragment())
        }
    }

    private fun setupRecyclerView() {
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
        descriptionTextView.text = day.description
        durationTextView.text = day.durationDescription()
    }
}