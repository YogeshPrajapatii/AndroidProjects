package com.yogesh.weatherapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yogesh.weatherapp.presentation.WeatherScreen
import com.yogesh.weatherapp.presentation.WeatherSplash
import com.yogesh.weatherapp.presentation.WeatherViewModel

@Composable
fun Navigation(viewModel: WeatherViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WeatherSplash) {
        composable<Routes.WeatherSplash> { WeatherSplash(navController) }

        composable<Routes.WeatherScreen> { WeatherScreen(viewModel, navController) }
    }
}
