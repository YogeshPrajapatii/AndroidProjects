package com.yogesh.stylish.domain.usecase

import android.util.Patterns
import com.yogesh.stylish.domain.repository.AuthRepository
import com.yogesh.stylish.domain.util.Result

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String): Result<String> {

        if (email.isBlank()) {

            return Result.Failure("Email can't be empty!")

        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return Result.Failure("Invalid email format!")
        }

        if (password.isBlank()) {
            return Result.Failure("Password can't be empty")
        }

        if (password.contains(" ")) {
            return Result.Failure("Password should not contain spaces")
        }
        if (password.length < 6) {
            return Result.Failure("Password must contain at least 6 characters!")
        }

        return repository.login(email, password)

    }

}