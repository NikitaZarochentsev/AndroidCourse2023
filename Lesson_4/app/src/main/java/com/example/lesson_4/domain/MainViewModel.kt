package com.example.lesson_4.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lesson_4.data.models.Weather
import com.example.lesson_4.data.weather.WeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    val weatherLiveData = MutableLiveData<Weather>()

    var errorMessage = MutableLiveData<String>()

    private val weatherService = WeatherService()

    fun setCity(location: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val weather = weatherService.getWeather(location)
                withContext(Dispatchers.Main) {
                    weatherLiveData.value = weather
                }
            } catch (t: Throwable) {
                withContext(Dispatchers.Main) {
                    errorMessage.value = t.message
                }
            }
        }
    }
}