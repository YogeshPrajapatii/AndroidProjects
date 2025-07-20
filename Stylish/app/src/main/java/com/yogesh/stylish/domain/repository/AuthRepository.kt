package com.yogesh.stylish.domain.repository

import com.yogesh.stylish.domain.util.Result

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<String>
    suspend fun signup(email: String, password: String): Result<String>
}