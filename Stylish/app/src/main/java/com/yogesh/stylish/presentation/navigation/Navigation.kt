package com.yogesh.stylish.presentation.navigation

import Splash
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.yogesh.stylish.data.repositoryimp.AuthRepositoryImp
import com.yogesh.stylish.domain.usecase.LoginUseCase
import com.yogesh.stylish.domain.usecase.SignUpUseCase
import com.yogesh.stylish.presentation.ui.screens.HomeScreen
import com.yogesh.stylish.presentation.ui.screens.authscreens.AuthViewModel
import com.yogesh.stylish.presentation.ui.screens.authscreens.ForgotPassword
import com.yogesh.stylish.presentation.ui.screens.authscreens.Login
import com.yogesh.stylish.presentation.ui.screens.authscreens.ResetPassword
import com.yogesh.stylish.presentation.ui.screens.authscreens.SignUp
import com.yogesh.stylish.presentation.ui.screens.onboardingscreens.OnBoarding1
import com.yogesh.stylish.presentation.ui.screens.onboardingscreens.OnBoarding2
import com.yogesh.stylish.presentation.ui.screens.onboardingscreens.OnBoarding3

@Composable
fun Navigation(authViewModel: AuthViewModel) {

    val navController = rememberNavController()

   

    NavHost(navController = navController, startDestination = Routes.Splash) {

        composable<Routes.Splash> { Splash(navController) }

        composable<Routes.OnBoarding1> {
            OnBoarding1(navController)
        }
        composable<Routes.OnBoarding2> { OnBoarding2(navController) }
        composable<Routes.OnBoarding3> { OnBoarding3(navController) }

        composable<Routes.SignUp> {
            SignUp(navController,authViewModel)
        }

        composable<Routes.Login> {
            Login(navController, authViewModel)
        }

        composable<Routes.ForgotPassword> {
            ForgotPassword(navController)
        }

        composable<Routes.ResetPassword> { ResetPassword(navController) }

        composable<Routes.HomeScreen> { HomeScreen(navController) }


    }

}