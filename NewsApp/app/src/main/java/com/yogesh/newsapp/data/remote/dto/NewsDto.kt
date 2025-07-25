package com.yogesh.newsapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class NewsDto(
    val articles: List<Article>,
    val status: String?,
    val totalResults: Int?
)