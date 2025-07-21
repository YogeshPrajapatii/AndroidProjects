package com.yogesh.weatherapp.domain.repository

import com.yogesh.weatherapp.data.dto.WeatherDto

interface WeatherRepository {
    
    suspend fun getWeather(city: String): WeatherDto
    
}