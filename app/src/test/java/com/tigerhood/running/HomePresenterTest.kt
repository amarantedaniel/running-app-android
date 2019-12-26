package com.tigerhood.running

import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.presenter.HomePresenter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomePresenterTest {

    @Mock
    private lateinit var view: HomeContract.View

    @Mock
    private lateinit var interactor: HomeContract.Interactor

    private val day = WorkoutDay("1", 1, 1, "Description 1", listOf())

    @Before
    fun init() {
        `when`(interactor.loadWorkoutDays()).thenReturn(listOf(day))
    }

    @Test
    fun onViewCreated_shouldCallViewFunctionsWithListOfDays() {
        val presenter = HomePresenter(view, interactor)
        presenter.onViewCreated()

        verify(view).updateSelectedDay(day)
        verify(view).updateWorkoutDays(listOf(day))
    }
}
