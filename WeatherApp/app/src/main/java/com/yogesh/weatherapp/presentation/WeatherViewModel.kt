package com.yogesh.weatherapp.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogesh.weatherapp.data.dto.WeatherDto
import com.yogesh.weatherapp.domain.repository.WeatherRepository
import com.yogesh.weatherapp.util.Result
import kotlinx.coroutines.launch

class WeatherViewModel(private val weatherRepository: WeatherRepository
) : ViewModel() {

    val city = mutableStateOf("")
    val weatherState = mutableStateOf<Result<WeatherDto>>(Result.Idle)
    val errorMessage = mutableStateOf<String?>(null)

    fun getWeather() {
        if (city.value.isBlank()) {
            errorMessage.value = "Please enter a valid city name!"
            return
        }

        viewModelScope.launch {
            weatherState.value = Result.Loading
            try {
                val response = weatherRepository.getWeather(city.value)
                weatherState.value = Result.Success(response)
                city.value = ""
            } catch (e: Exception) {
                errorMessage.value = "Something went wrong"
                weatherState.value = Result.Error(errorMessage.value!!)
            }
        }
    }
}
