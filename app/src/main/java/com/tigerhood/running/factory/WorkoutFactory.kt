package com.tigerhood.running.factory

import com.tigerhood.running.WorkoutContract
import com.tigerhood.running.presenter.WorkoutPresenter
import com.tigerhood.running.view.fragments.WorkoutFragment

class WorkoutFactoryImpl : WorkoutFactory {
    override fun createPresenter(view: WorkoutFragment): WorkoutContract.Presenter {
        return WorkoutPresenter(view)
    }
}

interface WorkoutFactory {
    fun createPresenter(view: WorkoutFragment): WorkoutContract.Presenter
}