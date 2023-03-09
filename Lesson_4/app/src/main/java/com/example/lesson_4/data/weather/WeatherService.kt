package com.example.lesson_4.data.weather

import com.example.lesson_4.data.models.Weather
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class WeatherService {

    companion object {
        private const val BASE_URL = "https://api.weatherapi.com/v1/"
    }

    private val weatherAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(WeatherAPI::class.java)

    suspend fun getWeather(location: String): Weather {
        val weather = weatherAPI.getWeather(location)
        return Weather(weather.location.name, weather.current.temp_c)
    }
}