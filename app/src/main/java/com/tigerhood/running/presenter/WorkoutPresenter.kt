package com.tigerhood.running.presenter

import com.tigerhood.running.WorkoutContract
import com.tigerhood.running.view.fragments.WorkoutFragmentArgs

class WorkoutPresenter(override var view: WorkoutContract.View?) : WorkoutContract.Presenter {
    override fun onViewCreated(args: WorkoutFragmentArgs) {
        view?.renderWorkoutDay(args.workoutDay)
    }
}