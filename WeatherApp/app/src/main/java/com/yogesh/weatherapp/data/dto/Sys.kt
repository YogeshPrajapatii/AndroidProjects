package com.yogesh.weatherapp.data.dto
import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    val country: String,
    val sunrise: Long,
    val sunset: Long
    // type and id ko skip kar diya because wo response me nahi hai
)
