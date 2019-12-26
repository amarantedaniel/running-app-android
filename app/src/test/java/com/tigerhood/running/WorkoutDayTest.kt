package com.tigerhood.running

import com.tigerhood.running.entity.WorkoutDay
import com.tigerhood.running.entity.WorkoutSegment
import junit.framework.Assert.assertEquals
import org.junit.Test

class WorkoutDayTest {
    
    @Test
    fun durationDescription_shouldSumSegmentsDurationAndFormatAsMinutes() {
        val segments = listOf(WorkoutSegment(60), WorkoutSegment(60))
        val day = WorkoutDay("1", 1, 1, "", segments)
        assertEquals("DURATION: 2 MINUTES", day.durationDescription())
    }

    @Test
    fun durationDescription_shouldIgnoreSecondsAndOnlyConsiderRoundMinutes() {
        val segments = listOf(WorkoutSegment(60), WorkoutSegment(30))
        val day = WorkoutDay("1", 1, 1, "", segments)
        assertEquals("DURATION: 1 MINUTES", day.durationDescription())
    }
}