package com.yogesh.weatherapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
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
import androidx.navigation.NavHostController
import com.yogesh.weatherapp.R
import com.yogesh.weatherapp.data.dto.WeatherDto
import com.yogesh.weatherapp.util.Result

@Composable
fun WeatherScreen(viewModel: WeatherViewModel, navController: NavHostController) {
    val city = viewModel.city.value
    val weatherState = viewModel.weatherState.value
    val errorMessage = viewModel.errorMessage.value

    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.bg_weather),
            contentDescription = "Weather Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.8f))

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 40.dp)
            .padding(top = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top) {
            //  Friendly Heading
            Text(text = "Know Your City Weather 🌤️",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 24.dp))

            //  Outlined TextField
            OutlinedTextField(value = city,
                onValueChange = { viewModel.city.value = it },
                label = { Text("Enter City") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.LightGray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.LightGray),
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .padding(bottom = 16.dp))

            //  Modern Button
            Button(onClick = { viewModel.getWeather() },
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(52.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))) {
                if (weatherState is Result.Loading) {
                    CircularProgressIndicator(color = Color.White,
                        modifier = Modifier.size(24.dp),
                        strokeWidth = 2.dp)
                } else {
                    Text("Get Weather", color = Color.White, fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            //  Weather Results
            when (weatherState) {
                is Result.Idle -> {
                    Text(text = "Enter a city to fetch weather info.",
                        color = Color.White,
                        fontSize = 18.sp)
                }

                is Result.Success -> {
                    WeatherCard(weatherState.data)
                }

                is Result.Error -> {
                    Text(text = "Error: ${weatherState.message}",
                        color = Color.Red,
                        fontSize = 14.sp)
                }

                else -> {}
            }

            //  Snackbar for Errors
            if (errorMessage != null && weatherState !is Result.Error) {
                errorMessage.let {
                    Snackbar(action = {
                        Text("Dismiss", modifier = Modifier.clickable {
                            viewModel.errorMessage.value = null
                        })
                    }, modifier = Modifier.padding(top = 8.dp)) {
                        Text(it)
                    }
                }
            }
        }
    }
}

@Composable
fun WeatherCard(weather: WeatherDto) {
    Card(shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xCCFFFFFF)),
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = weather.name ?: "Unknown City",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))
            weather.main?.let { main ->
                Text(text = "${main.temp}°C",
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.SemiBold))
                Text("Feels like: ${main.feels_like}°C")
                Text("Humidity: ${main.humidity}%")
                Text("Pressure: ${main.pressure} hPa")
            }
            weather.wind?.let { wind ->
                Text("Wind: ${wind.speed} m/s, ${wind.deg}°")
            }
            weather.weather?.firstOrNull()?.let { condition ->
                Text("Condition: ${condition.description}")
            }
        }
    }
}
