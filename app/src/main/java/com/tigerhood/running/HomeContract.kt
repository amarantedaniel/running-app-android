package com.tigerhood.running

import com.tigerhood.running.entity.WorkoutDay

interface HomeContract {
    interface View {
        fun updateWorkoutDays(days: List<WorkoutDay>)
        fun updateSelectedIndex(index: Int)
    }

    interface Presenter {
        fun onViewCreated()
        fun onDestroy()
        fun onItemSelected(index: Int)
    }

    interface Interactor {
        fun loadWorkoutDays(): List<WorkoutDay>
    }
}