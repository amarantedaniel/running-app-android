package com.tigerhood.running.presenter

import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutDay

class HomePresenter(
    var view: HomeContract.View?,
    var router: HomeContract.Router?,
    var interactor: HomeContract.Interactor?
) : HomeContract.Presenter {

    override fun onViewCreated() {
        val days = interactor?.loadWorkoutDays() ?: listOf()
        view?.updateWorkoutDays(days)
        days.firstOrNull()?.let {
            view?.updateSelectedDay(it)
        }
    }

    override fun onDestroy() {
        view = null
        interactor = null
        router = null
    }

    override fun onDaySelected(day: WorkoutDay) {
        view?.updateSelectedDay(day)
    }

    override fun onStartWorkoutClicked() {
        router?.navigateToWorkout()
    }
}