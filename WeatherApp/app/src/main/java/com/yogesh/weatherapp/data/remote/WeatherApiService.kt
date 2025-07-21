package com.yogesh.weatherapp.data.remote

import com.yogesh.weatherapp.data.dto.WeatherDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class WeatherApiService(private val apiKey: String) {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                coerceInputValues = true // ✅ Missing fields ke liye default values use karega
            })
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 15000 // 15 seconds
            connectTimeoutMillis = 15000
            socketTimeoutMillis = 15000
        }

        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.openweathermap.org"
            }
        }
    }

    suspend fun getWeather(city: String): WeatherDto {
        return try {
            val response = client.get("/data/2.5/weather") {
                parameter("q", city)
                parameter("appid", apiKey)
                parameter("units", "metric")
            }

            val responseBody = response.bodyAsText() // 👈 Ye import karo: io.ktor.client.call.bodyAsText
            println("API Response: $responseBody") // 👀 Console me API ka raw JSON dekhne ke liye

            Json.decodeFromString<WeatherDto>(responseBody) // ✅ Response ko DTO me convert
        } catch (e: Exception) {
            e.printStackTrace()
            throw Exception("Failed to fetch weather data: ${e.localizedMessage}")
        }
    }

}
