package com.tigerhood.running.interactor

import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutDay

class HomeInteractor : HomeContract.Interactor {
    override fun loadWorkoutDays(): List<WorkoutDay> = listOf(
        WorkoutDay("", 1, 1, "Description 1"),
        WorkoutDay("", 1, 2, "Description 2"),
        WorkoutDay("", 1, 3, "Description 3"),
        WorkoutDay("", 2, 1, "Description 4"),
        WorkoutDay("", 2, 2, "Description 5"),
        WorkoutDay("", 2, 3, "Description 5"),
        WorkoutDay("", 3, 1, "Description 5"),
        WorkoutDay("", 3, 2, "Description 5"),
        WorkoutDay("", 3, 3, "Description 5")
    )
}