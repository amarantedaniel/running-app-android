package com.tigerhood.running.interactor

import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.interactor.repository.HomeRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class HomeInteractorTest {

    @Mock
    private lateinit var output: HomeContract.InteractorOutput

    @Mock
    private lateinit var repository: HomeRepository

    private val workoutDays = listOf(
        WorkoutDay("", 1, 1, "Description 1", listOf()),
        WorkoutDay("", 1, 2, "Description 2", listOf()),
        WorkoutDay("", 1, 3, "Description 3", listOf())
    )

    @Before
    fun setUp() {
        `when`(repository.getWorkoutDays()).thenReturn(workoutDays)
    }

    @Test
    fun loadWorkoutDays_shouldCallOutputWithHardcodedWorkoutDays() {
        val interactor = HomeInteractor(repository)
        interactor.output = output
        interactor.loadWorkoutDays()
        verify(output).onWorkoutDaysLoaded(workoutDays)
    }
}