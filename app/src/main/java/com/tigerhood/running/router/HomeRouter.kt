package com.tigerhood.running.router

import androidx.navigation.NavController
import com.tigerhood.running.HomeContract
import com.tigerhood.running.view.fragments.HomeFragmentDirections

class HomeRouter(private val navController: NavController) : HomeContract.Router {
    override fun navigateToWorkout() {
        val directions = HomeFragmentDirections.navigateToWorkoutFragment()
        navController.navigate(directions)
    }
}