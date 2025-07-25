package com.yogesh.newsapp.util

sealed class NewsResult<out T> {

    data object Idle : NewsResult<Nothing>()
    data object Loading : NewsResult<Nothing>()
    data class Success<T>(val data: T) : NewsResult<T>()
    data class Error(val message: String?) : NewsResult<Nothing>()

}