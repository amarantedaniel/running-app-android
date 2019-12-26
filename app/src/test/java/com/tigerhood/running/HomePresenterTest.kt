package com.tigerhood.running

import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.presenter.HomePresenter
import org.junit.Test
import org.mockito.Mockito.*


class HomePresenterTest {
    @Test
    fun whenOnViewCreatedIsCalledShouldWork() {
        val interactor = mock(HomeContract.Interactor::class.java)
        val view = mock(HomeContract.View::class.java)
        val day = WorkoutDay("1", 1, 1, "Description 1", listOf())
        `when`(interactor.loadWorkoutDays()).thenReturn(listOf(day))

        val presenter = HomePresenter(view, interactor)
        presenter.onViewCreated()

        verify(view).updateSelectedDay(day)
        verify(view).updateWorkoutDays(listOf(day))
    }
}
