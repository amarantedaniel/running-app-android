package com.tigerhood.running.interactor.repository

import android.content.Context

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.tigerhood.running.entity.WorkoutDay

class HomeRepository(private val context: Context?) {
    fun getWorkoutDays(): List<WorkoutDay> {
        context?.assets?.open("workout_days.json").use { inputStream ->
            JsonReader(inputStream?.reader()).use { jsonReader ->
                val type = object : TypeToken<List<WorkoutDay>>() {}.type
                return Gson().fromJson(jsonReader, type)
            }
        }
    }
}
