package com.tigerhood.running.presenter

import androidx.navigation.NavController
import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.interactor.HomeInteractor
import com.tigerhood.running.view.routers.HomeRouter

class HomePresenter(
    var view: HomeContract.View?,
    navController: NavController,
    var interactor: HomeContract.Interactor? = HomeInteractor()
) : HomeContract.Presenter {

    var router: HomeContract.Router? = null

    init {
        this.router = HomeRouter(navController)
    }

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