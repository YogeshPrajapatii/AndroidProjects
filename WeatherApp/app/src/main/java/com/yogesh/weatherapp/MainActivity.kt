package com.yogesh.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yogesh.weatherapp.data.remote.WeatherApiService
import com.yogesh.weatherapp.data.repositoryimp.WeatherRepoImp
import com.yogesh.weatherapp.presentation.WeatherScreen
import com.yogesh.weatherapp.presentation.WeatherViewModel
import com.yogesh.weatherapp.presentation.navigation.Navigation
import com.yogesh.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {

    private val apiKey = "7ed70440294057645d38c7899b20878d" // My API Key

    // Ktor Service Inject
    private val weatherApiService by lazy {
        WeatherApiService(apiKey)
    }

    //  Repository Inject
    private val weatherRepository by lazy {
        WeatherRepoImp(weatherApiService)
    }

    //  ViewModel Inject 
    private val viewModel by viewModels<WeatherViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return WeatherViewModel(weatherRepository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppTheme {
                Navigation(viewModel)
            }
        }
    }
}
