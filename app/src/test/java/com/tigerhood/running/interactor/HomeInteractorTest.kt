package com.tigerhood.running.interactor

import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.entity.WorkoutSegment
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeInteractorTest {
    @Mock
    private lateinit var output: HomeContract.InteractorOutput

    private val hardcodedWorkoutDays = listOf(
        WorkoutDay("", 1, 1, "Description 1", hardCodedSegments()),
        WorkoutDay("", 1, 2, "Description 2", hardCodedSegments()),
        WorkoutDay("", 1, 3, "Description 3", hardCodedSegments()),
        WorkoutDay("", 2, 1, "Description 4", hardCodedSegments()),
        WorkoutDay("", 2, 2, "Description 6", hardCodedSegments()),
        WorkoutDay("", 2, 3, "Description 7", hardCodedSegments()),
        WorkoutDay("", 3, 1, "Description 8", hardCodedSegments()),
        WorkoutDay("", 3, 2, "Description 9", hardCodedSegments()),
        WorkoutDay("", 3, 3, "Description 10", hardCodedSegments())
    )

    private fun hardCodedSegments() =
        listOf(WorkoutSegment(300), WorkoutSegment(1800), WorkoutSegment(300))

    @Test
    fun loadWorkoutDays_shouldCallOutputWithHardcodedWorkoutDays() {
        val interactor = HomeInteractor()
        interactor.output = output
        interactor.loadWorkoutDays()
        verify(output).onWorkoutDaysLoaded(hardcodedWorkoutDays)
    }
}