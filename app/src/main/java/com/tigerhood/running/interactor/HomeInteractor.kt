package com.tigerhood.running.interactor

import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.entity.WorkoutSegment

class HomeInteractor : HomeContract.Interactor {
    override fun loadWorkoutDays(): List<WorkoutDay> = listOf(
        WorkoutDay("", 1, 1, "Description 1", segments()),
        WorkoutDay("", 1, 2, "Description 2", segments()),
        WorkoutDay("", 1, 3, "Description 3", segments()),
        WorkoutDay("", 2, 1, "Description 4", segments()),
        WorkoutDay("", 2, 2, "Description 6", segments()),
        WorkoutDay("", 2, 3, "Description 7", segments()),
        WorkoutDay("", 3, 1, "Description 8", segments()),
        WorkoutDay("", 3, 2, "Description 9", segments()),
        WorkoutDay("", 3, 3, "Description 10", segments())
    )

    private fun segments() = listOf(WorkoutSegment(300), WorkoutSegment(1800), WorkoutSegment(300))
}
