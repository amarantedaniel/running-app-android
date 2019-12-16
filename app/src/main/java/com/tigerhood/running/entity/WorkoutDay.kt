package com.tigerhood.running.entity

data class WorkoutDay(
    val id: String,
    val week: Int,
    val day: Int,
    val description: String,
    val segments: List<WorkoutSegment>
) {

    fun durationDescription(): String {
        val durationInSeconds = segments.sumBy { it.length }
        val duration = durationInSeconds / 60
        return "DURATION: $duration MINUTES"
    }
}
