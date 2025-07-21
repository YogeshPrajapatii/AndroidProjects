package com.yogesh.weatherapp.data.dto

import kotlinx.serialization.Serializable
@Serializable
data class Wind(
    val deg: Int,
    val gust: Double? = null, // gust is optional
    val speed: Double
)
