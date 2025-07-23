package com.yogesh.weatherapp.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object WeatherSplash : Routes()

    @Serializable
    object WeatherScreen : Routes()
}



