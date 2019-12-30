package com.tigerhood.running

import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.view.fragments.WorkoutFragmentArgs

interface WorkoutContract {
    interface View {
        var presenter: Presenter?
        fun renderWorkoutDay(day: WorkoutDay)
    }

    interface Presenter {
        var view: View?
        fun onViewCreated(args: WorkoutFragmentArgs)
    }
}