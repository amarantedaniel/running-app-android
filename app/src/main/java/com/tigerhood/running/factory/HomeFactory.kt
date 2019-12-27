package com.tigerhood.running.factory

import androidx.navigation.fragment.findNavController
import com.tigerhood.running.interactor.HomeInteractor
import com.tigerhood.running.presenter.HomePresenter
import com.tigerhood.running.router.HomeRouter
import com.tigerhood.running.view.fragments.HomeFragment

object HomeFactory {
    fun createPresenter(view: HomeFragment): HomePresenter {
        val router = HomeRouter(view.findNavController())
        val interactor = HomeInteractor()
        return HomePresenter(view, router, interactor)
    }
}