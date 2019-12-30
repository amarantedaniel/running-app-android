package com.tigerhood.running.view.fragments

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tigerhood.running.HomeContract
import com.tigerhood.running.R
import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.factory.HomeFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Mock
    private lateinit var presenter: HomeContract.Presenter
    @Mock
    private lateinit var factory: HomeFactory

    private lateinit var scenario: FragmentScenario<HomeFragment>
    private val day = WorkoutDay("1", 1, 1, "Description 1", listOf())

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        `when`(factory.createPresenter(any())).thenReturn(presenter)

        scenario = launchFragmentInContainer {
            HomeFragment().apply {
                this.factory = this@HomeFragmentTest.factory
            }
        }
    }

    private fun <T> any(): T = Mockito.any<T>()

    @Test
    fun onCreation_shouldCallPresenterOnViewCreated() {
        verify(presenter).onViewCreated()
    }

    @Test
    fun shouldNavigateOnButtonClick() {
        onView(withId(R.id.startButton)).perform(click())
        verify(presenter).onStartWorkoutClicked()
    }

    @Test
    fun onDestroyView_shouldCallPresenterOnDestroy() {
        scenario.moveToState(Lifecycle.State.DESTROYED)
        verify(presenter).onDestroy()
    }

    @Test
    fun shouldCallPresenterOnSelectWhenDayIsSelected() {
        scenario.onFragment { it.updateWorkoutDays(listOf(day)) }
        onView(withId(R.id.recyclerView)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        verify(presenter).onDaySelected(day)
    }
}