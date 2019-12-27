package com.tigerhood.running.router

import androidx.navigation.NavController
import com.tigerhood.running.view.fragments.HomeFragmentDirections
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeRouterTest {
    @Mock
    private lateinit var navController: NavController

    @Test
    fun navigateToWorkout_callsNavControllerWithCorrectDirections() {
        val router = HomeRouter(navController)
        router.navigateToWorkout()
        verify(navController).navigate(HomeFragmentDirections.navigateToWorkoutFragment())
    }

}