package com.tigerhood.running

import com.tigerhood.running.entity.WorkoutDay

interface HomeContract {
    interface View {
        fun updateWorkoutDays(days: List<WorkoutDay>)
        fun updateSelectedDay(day: WorkoutDay)
    }

    interface Presenter {
        fun onViewCreated()
        fun onDestroy()
        fun onDaySelected(day: WorkoutDay)
    }

    interface Interactor {
        fun loadWorkoutDays(): List<WorkoutDay>
    }
}