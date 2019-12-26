package com.tigerhood.running.presenter

import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.interactor.HomeInteractor

class HomePresenter(
    private var view: HomeContract.View?,
    private var interactor: HomeContract.Interactor? = HomeInteractor()
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
    }

    override fun onDaySelected(day: WorkoutDay) {
        view?.updateSelectedDay(day)
    }
}