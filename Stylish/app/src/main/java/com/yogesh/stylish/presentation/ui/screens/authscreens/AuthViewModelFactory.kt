package com.yogesh.stylish.presentation.ui.screens.authscreens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yogesh.stylish.domain.usecase.LoginUseCase
import com.yogesh.stylish.domain.usecase.SignUpUseCase
class AuthViewModelFactory(private val loginUseCase: LoginUseCase,
                           private val signUpUseCase: SignUpUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return AuthViewModel(loginUseCase, signUpUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
