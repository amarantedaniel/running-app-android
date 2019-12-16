package com.tigerhood.running.presenter

import com.tigerhood.running.HomeContract

class HomePresenter(private var view: HomeContract.View?) : HomeContract.Presenter,
    HomeContract.InteractorOutput {
    override fun onViewCreated() {

    }

    override fun onDestroy() {

    }
}