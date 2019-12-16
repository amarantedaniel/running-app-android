package com.tigerhood.running.presenter

import com.tigerhood.running.HomeContract
import com.tigerhood.running.interactor.HomeInteractor

class HomePresenter(private var view: HomeContract.View?) : HomeContract.Presenter {

    private var interactor: HomeContract.Interactor? = HomeInteractor()

    override fun onViewCreated() {
        val days = interactor?.loadWorkoutDays() ?: listOf()
        view?.updateWorkoutDays(days)
    }

    override fun onDestroy() {
        view = null
        interactor = null
    }

    override fun onItemSelected(index: Int) {
        view?.updateSelectedIndex(index)
    }
}