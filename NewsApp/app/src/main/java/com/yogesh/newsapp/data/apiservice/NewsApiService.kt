package com.yogesh.newsapp.data.apiservice

import com.yogesh.newsapp.data.remote.dto.Article
import com.yogesh.newsapp.data.remote.dto.NewsDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NewsApiService(private val apiKey: String) {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                coerceInputValues = true
            })
        }

        install(HttpTimeout) {
            requestTimeoutMillis = 15000
            socketTimeoutMillis = 15000
            connectTimeoutMillis = 15000
        }

        defaultRequest {
            url {
                protocol = URLProtocol.HTTPS
                host = "newsapi.org"
            }
        }
    }

    // com.yogesh.newsapp.data.apiservice/NewsApiService.kt

    suspend fun getNews(): List<Article> {
        // try-catch हटा दिया गया है
        val response: NewsDto = client.get("/v2/top-headlines") {
            parameter("apiKey", apiKey)
            parameter("country", "us")
            parameter("category", "business")
        }.body()

        return response.articles
    }
}
