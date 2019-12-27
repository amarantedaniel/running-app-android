package com.tigerhood.running.router

import androidx.navigation.NavController
import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.view.fragments.HomeFragmentDirections

class HomeRouter(private val navController: NavController) : HomeContract.Router {
    override fun navigateToWorkout(workoutDay: WorkoutDay) {
        val directions = HomeFragmentDirections.navigateToWorkoutFragment(workoutDay)
        navController.navigate(directions)
    }
}