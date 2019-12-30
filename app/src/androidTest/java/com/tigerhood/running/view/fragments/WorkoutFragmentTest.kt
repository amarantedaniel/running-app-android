package com.tigerhood.running.view.fragments

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tigerhood.running.R
import com.tigerhood.running.WorkoutContract
import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.factory.WorkoutFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class WorkoutFragmentTest {
    @Mock
    private lateinit var presenter: WorkoutContract.Presenter
    @Mock
    private lateinit var factory: WorkoutFactory

    private lateinit var scenario: FragmentScenario<WorkoutFragment>
    private val day = WorkoutDay("1", 1, 1, "Description 1", listOf())

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(factory.createPresenter(any())).thenReturn(presenter)
        val direction = HomeFragmentDirections.navigateToWorkoutFragment(day)
        scenario = launchFragmentInContainer(direction.arguments) {
            WorkoutFragment().apply { this.factory = this@WorkoutFragmentTest.factory }
        }
    }

    private fun <T> any(): T = Mockito.any<T>()

    @Test
    fun callsPresenterOnViewCreatedWithArgs() {
        val direction = HomeFragmentDirections.navigateToWorkoutFragment(day)
        val args = WorkoutFragmentArgs.fromBundle(direction.arguments)
        verify(presenter).onViewCreated(args)
    }

    @Test
    fun renderWorkoutDay_updatesUI() {
        scenario.onFragment { it.renderWorkoutDay(day) }
        onView(withId(R.id.descriptionTextView)).check(matches(withText(day.description)))
        onView(withId(R.id.durationTextView)).check(matches(withText("DURATION: 0 MINUTES")))
    }
}