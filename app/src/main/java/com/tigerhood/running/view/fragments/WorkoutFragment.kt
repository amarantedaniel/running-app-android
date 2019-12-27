package com.tigerhood.running.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.tigerhood.running.R
import com.tigerhood.running.WorkoutContract
import kotlinx.android.synthetic.main.fragment_workout.*

class WorkoutFragment : Fragment(R.layout.fragment_workout), WorkoutContract.View {

    private val args: WorkoutFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView.text = args.workoutDay.description
    }
}