package com.yogesh.weatherapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class WeatherDto(
    val base: String? = null,
    val clouds: Clouds? = null,
    val cod: Int? = null,
    val coord: Coord? = null,
    val dt: Int? = null,
    val id: Int? = null,
    val main: Main? = null,
    val name: String? = null,
    val sys: Sys? = null,
    val timezone: Int? = null,
    val visibility: Int? = null,
    val weather: List<Weather>? = emptyList(),
    val wind: Wind? = null
)
