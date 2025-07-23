package com.yogesh.weatherapp.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yogesh.weatherapp.R
import com.yogesh.weatherapp.presentation.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun WeatherSplash(navController: NavHostController) {

    val jumpOffset = remember { Animatable(0f) }
    val fadeInAlpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        fadeInAlpha.animateTo(targetValue = 1f, animationSpec = tween(durationMillis = 500))

        jumpOffset.animateTo(targetValue = -40f,
            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMedium))

        jumpOffset.animateTo(targetValue = 0f,
            animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow))

        delay(500)
        navController.navigate(Routes.WeatherScreen) {
            popUpTo(Routes.WeatherSplash) { inclusive = true }
        }
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.verticalGradient(colors = listOf(Color(0xFF2196F3), // Blue
            Color(0xFF21CBF3)  // Light Blue
        ))), contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id = R.drawable.weather_splash),
            contentDescription = "Weather App Splash Screen",
            modifier = Modifier
                .size(150.dp)
                .offset(y = jumpOffset.value.dp)
                .graphicsLayer(alpha = fadeInAlpha.value))
    }
}
