package com.yogesh.stylish.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {
    @Serializable
    object Splash : Routes()

    @Serializable
    object OnBoarding1: Routes()

    @Serializable
    object OnBoarding2 : Routes()

    @Serializable
    object OnBoarding3 : Routes()

    @Serializable
    object SignUp : Routes()

    @Serializable
    object Login : Routes()

    @Serializable
    object ForgotPassword : Routes()
    @Serializable
    object HomeScreen: Routes()
    
    @Serializable
    object ResetPassword: Routes()
}