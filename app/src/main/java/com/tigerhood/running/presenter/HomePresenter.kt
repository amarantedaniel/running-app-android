package com.tigerhood.running.presenter

import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutDay

class HomePresenter(
    var view: HomeContract.View?,
    var router: HomeContract.Router?,
    var interactor: HomeContract.Interactor?
) : HomeContract.Presenter, HomeContract.InteractorOutput {

    var selectedDay: WorkoutDay? = null

    override fun onViewCreated() {
        interactor?.loadWorkoutDays()
    }

    override fun onWorkoutDaysLoaded(workoutDays: List<WorkoutDay>) {
        view?.updateWorkoutDays(workoutDays)
        workoutDays.firstOrNull()?.let {
            selectedDay = it
            view?.updateSelectedDay(it)
        }
    }

    override fun onDestroy() {
        view = null
        interactor = null
        router = null
    }

    override fun onDaySelected(day: WorkoutDay) {
        selectedDay = day
        view?.updateSelectedDay(day)
    }

    override fun onStartWorkoutClicked() {
        selectedDay?.let {
            router?.navigateToWorkout(it)
        }
    }
}