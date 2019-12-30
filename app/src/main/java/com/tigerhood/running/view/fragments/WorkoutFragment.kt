package com.tigerhood.running.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.tigerhood.running.R
import com.tigerhood.running.WorkoutContract
import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.factory.WorkoutFactory
import com.tigerhood.running.factory.WorkoutFactoryImpl
import kotlinx.android.synthetic.main.layout_workout_description.*

class WorkoutFragment : Fragment(R.layout.fragment_workout), WorkoutContract.View {

    override var presenter: WorkoutContract.Presenter? = null
    var factory: WorkoutFactory = WorkoutFactoryImpl()

    private val args: WorkoutFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = factory.createPresenter(this)
        presenter?.onViewCreated(args)
    }

    override fun renderWorkoutDay(day: WorkoutDay) {
        descriptionTextView.text = day.description
        durationTextView.text = day.durationDescription()
    }
}