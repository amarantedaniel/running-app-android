package com.tigerhood.running

import com.tigerhood.running.entity.WorkoutDay

interface HomeContract {
    interface View {
        fun updateWorkoutDays(days: List<WorkoutDay>)
    }

    interface Presenter {
        fun onViewCreated()
        fun onDestroy()

    }

    interface Interactor {
        fun loadWorkoutDays(): List<WorkoutDay>
    }
}