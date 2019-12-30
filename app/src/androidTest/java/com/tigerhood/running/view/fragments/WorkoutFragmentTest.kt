package com.tigerhood.running.view.fragments

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tigerhood.running.R
import com.tigerhood.running.entity.WorkoutDay
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WorkoutFragmentTest {
    private val day = WorkoutDay("1", 1, 1, "Description 1", listOf())

    @Before
    fun setUp() {
        val direction = HomeFragmentDirections.navigateToWorkoutFragment(day)
        launchFragmentInContainer<WorkoutFragment>(direction.arguments)
    }


    @Test
    fun textIsLoadedOnScreen() {
        onView(withId(R.id.descriptionTextView)).check(matches(withText(day.description)))
        onView(withId(R.id.durationTextView)).check(matches(withText("DURATION: 0 MINUTES")))
    }

}