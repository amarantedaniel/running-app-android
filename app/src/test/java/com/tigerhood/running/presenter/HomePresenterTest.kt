package com.tigerhood.running.presenter

import com.tigerhood.running.HomeContract
import com.tigerhood.running.entity.WorkoutDay
import junit.framework.TestCase.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
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

    @Test
    fun onViewCreated_shouldCallInteractorToLoadWorkoutDays() {
        val presenter = HomePresenter(view, router, interactor)
        presenter.onViewCreated()
        verify(interactor).loadWorkoutDays()
    }

    @Test
    fun onWorkoutDaysLoaded_shouldCallViewFunctionsWithListOfDays() {
        val presenter = HomePresenter(view, router, interactor)
        presenter.onWorkoutDaysLoaded(listOf(day))
        verify(view).updateSelectedDay(day)
        verify(view).updateWorkoutDays(listOf(day))
    }

    @Test
    fun onDestroy_shouldSetPresenterViewAndRouterToNull() {
        val presenter = HomePresenter(view, router, interactor)
        presenter.onDestroy()
        assertNull(presenter.interactor)
        assertNull(presenter.view)
        assertNull(presenter.router)
    }

    @Test
    fun onDaySelected_shouldUpdateSelectedDayOnView() {
        val presenter = HomePresenter(view, router, interactor)
        presenter.onDaySelected(day)
        verify(view).updateSelectedDay(day)
    }

    @Test
    fun onStartWorkoutClicked_shouldCallNavigateOnRouterWithSelectedDay() {
        val presenter = HomePresenter(view, router, interactor)
        presenter.onDaySelected(day)
        presenter.onStartWorkoutClicked()
        verify(router).navigateToWorkout(day)
    }
}
