package com.tigerhood.running

import com.tigerhood.running.entity.WorkoutDay

interface HomeContract {
    interface View {
        var presenter: Presenter?
        fun updateWorkoutDays(days: List<WorkoutDay>)
        fun updateSelectedDay(day: WorkoutDay)
    }

    interface Presenter {
        var view: View?
        var interactor: Interactor?
        var router: Router?
        fun onViewCreated()
        fun onDestroy()
        fun onDaySelected(day: WorkoutDay)
        fun onStartWorkoutClicked()
    }

    interface Interactor {
        var output: InteractorOutput?
        fun loadWorkoutDays()
    }

    interface InteractorOutput {
        fun onWorkoutDaysLoaded(workoutDays: List<WorkoutDay>)
    }

    interface Router {
        fun navigateToWorkout(workoutDay: WorkoutDay)
    }
}