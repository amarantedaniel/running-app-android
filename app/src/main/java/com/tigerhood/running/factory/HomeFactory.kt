package com.tigerhood.running.factory

import androidx.navigation.fragment.findNavController
import com.tigerhood.running.HomeContract
import com.tigerhood.running.interactor.HomeInteractor
import com.tigerhood.running.interactor.repository.HomeRepositoryImpl
import com.tigerhood.running.presenter.HomePresenter
import com.tigerhood.running.router.HomeRouter
import com.tigerhood.running.view.fragments.HomeFragment

class HomeFactoryImpl : HomeFactory {
    override fun createPresenter(view: HomeFragment): HomeContract.Presenter {
        val router = HomeRouter(view.findNavController())
        val repository = HomeRepositoryImpl(view.context)
        val interactor = HomeInteractor(repository)
        return HomePresenter(view, router, interactor).apply {
            this.interactor?.output = this
        }
    }
}

interface HomeFactory {
    fun createPresenter(view: HomeFragment): HomeContract.Presenter
}