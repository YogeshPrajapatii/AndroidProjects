package com.yogesh.stylish.domain.usecase
import com.yogesh.stylish.domain.util.Result
import com.yogesh.stylish.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String):Result<String> {

        return repository.login(email, password)

    }

}