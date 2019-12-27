package com.tigerhood.running.presenter

import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutDay
import junit.framework.TestCase.assertNull
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
    private lateinit var router: HomeContract.Router

    @Mock
    private lateinit var interactor: HomeContract.Interactor

    private val day = WorkoutDay("1", 1, 1, "Description 1", listOf())

    @Before
    fun init() {
        `when`(interactor.loadWorkoutDays()).thenReturn(listOf(day))
    }

    @Test
    fun onViewCreated_shouldCallViewFunctionsWithListOfDays() {
        val presenter = HomePresenter(view, router, interactor)
        presenter.onViewCreated()

        verify(view).updateSelectedDay(day)
        verify(view).updateWorkoutDays(listOf(day))
    }

    @Test
    fun onDestroy_shouldSetBothPresenterAndViewToNull() {
        val presenter = HomePresenter(view, router, interactor)
        presenter.onDestroy()
        assertNull(presenter.interactor)
        assertNull(presenter.view)
    }

    @Test
    fun onDaySelected_shouldUpdateSelectedDayOnView() {
        val presenter = HomePresenter(view, router, interactor)
        presenter.onDaySelected(day)
        verify(view).updateSelectedDay(day)
    }

    @Test
    fun onStartWorkoutClicked_shouldCallNavigateOnRouter() {
        val presenter = HomePresenter(view, router, interactor)
        presenter.onStartWorkoutClicked()
        verify(router).navigateToWorkout()
    }
}
