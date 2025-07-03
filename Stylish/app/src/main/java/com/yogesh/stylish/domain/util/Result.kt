package com.yogesh.stylish.domain.util

sealed class Result<out T>() {

    data object Ideal : Result<Nothing>()
    data object Loading : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()
    data class Failure(val message: String) : Result<Nothing>()


}

