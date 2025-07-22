package com.yogesh.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yogesh.weatherapp.R
import com.yogesh.weatherapp.data.dto.WeatherDto
import com.yogesh.weatherapp.util.Result

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val city = viewModel.city.value
    val weatherState = viewModel.weatherState.value
    val errorMessage = viewModel.errorMessage.value

    //  Background Image
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.bg_weather), //  Added bg_weather.png in drawable
            contentDescription = "Weather Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.9f))

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            TextField(value = city,
                onValueChange = { viewModel.city.value = it },
                label = { Text("Enter City") },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 16.dp))

            //  Button with loading indicator
            Button(onClick = { viewModel.getWeather() },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp)) {
                if (weatherState is Result.Loading) {
                    CircularProgressIndicator(color = Color.White,
                        modifier = Modifier.size(24.dp),
                        strokeWidth = 2.dp)
                } else {
                    Text("Get Weather")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            when (weatherState) {
                is Result.Idle -> {
                    Text(text = "Enter a city to get weather",
                        color = Color.White,
                        fontSize = 16.sp)
                }

                is Result.Success -> {
                    WeatherCard((weatherState as Result.Success<WeatherDto>).data)
                }

                is Result.Error -> {
                    Text(text = "Error: ${weatherState.message}",
                        color = Color.Red,
                        fontSize = 16.sp)
                }

                else -> {}
            }

            errorMessage?.let {
                Snackbar(action = { Text("Dismiss") }, modifier = Modifier.padding(top = 8.dp)) {
                    Text(it)
                }
            }
        }
    }
}

@Composable
fun WeatherCard(weather: WeatherDto) {
    Card(shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xAAFFFFFF)),
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = weather.name ?: "Unknown City",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))
            weather.main?.let { main ->
                Text(text = "${main.temp}°C",
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.SemiBold))
                Text(text = "Feels like: ${main.feels_like}°C")
                Text(text = "Humidity: ${main.humidity}%")
                Text(text = "Pressure: ${main.pressure} hPa")
            }
            weather.wind?.let { wind ->
                Text(text = "Wind: ${wind.speed} m/s, ${wind.deg}°")
            }
            weather.weather?.firstOrNull()?.let { condition ->
                Text(text = "Condition: ${condition.description}")
            }
        }
    }
}
