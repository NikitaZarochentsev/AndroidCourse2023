package com.example.lesson_4.data.weather

import com.example.lesson_4.data.models.WeatherResponce
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("current.json?key=0b5eabd322264b898e1172907230703&aqi=no")
    suspend fun getWeather(
        @Query("q")
        location: String
    ): WeatherResponce
}