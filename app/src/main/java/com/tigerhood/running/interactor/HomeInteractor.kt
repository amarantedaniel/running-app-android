package com.tigerhood.running.interactor

import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutSegment
import com.tigerhood.running.interactor.repository.HomeRepository

class HomeInteractor(val repository: HomeRepository) : HomeContract.Interactor {
    override var output: HomeContract.InteractorOutput? = null

    override fun loadWorkoutDays() {
        output?.onWorkoutDaysLoaded(repository.getWorkoutDays())
    }
}
