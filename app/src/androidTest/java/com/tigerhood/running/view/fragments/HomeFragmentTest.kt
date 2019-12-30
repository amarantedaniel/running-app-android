package com.tigerhood.running.view.fragments

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tigerhood.running.HomeContract
import com.tigerhood.running.R
import com.tigerhood.running.factory.HomeFactory
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    private lateinit var scenario: FragmentScenario<HomeFragment>
    private val presenter = mock(HomeContract.Presenter::class.java)

    @Before
    fun setUp() {
        val factory = mock(HomeFactory::class.java)

        scenario = launchFragmentInContainer {
            HomeFragment().apply {
                `when`(factory.createPresenter(this)).thenReturn(presenter)
                this.factory = factory
            }
        }
    }

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
}