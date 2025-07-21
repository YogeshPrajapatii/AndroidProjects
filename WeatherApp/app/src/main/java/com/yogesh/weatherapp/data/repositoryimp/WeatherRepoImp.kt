package com.yogesh.weatherapp.data.repositoryimp

import com.yogesh.weatherapp.data.dto.WeatherDto
import com.yogesh.weatherapp.data.remote.WeatherApiService
import com.yogesh.weatherapp.domain.repository.WeatherRepository

class WeatherRepoImp(private val apiService: WeatherApiService): WeatherRepository{
    override suspend fun getWeather(city: String): WeatherDto {
        return apiService.getWeather(city)
    }
}