package com.tigerhood.running.presenter

import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutDay

class HomePresenter(
    var view: HomeContract.View?,
    var router: HomeContract.Router?,
    var interactor: HomeContract.Interactor?
) : HomeContract.Presenter {

    var selectedDay: WorkoutDay? = null

    override fun onViewCreated() {
        val days = interactor?.loadWorkoutDays() ?: listOf()
        view?.updateWorkoutDays(days)
        days.firstOrNull()?.let {
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