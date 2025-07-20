package com.yogesh.stylish.presentation.navigation

import Splash
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yogesh.stylish.presentation.ui.screens.HomeScreen
import com.yogesh.stylish.presentation.ui.screens.authscreens.ForgotPassword
import com.yogesh.stylish.presentation.ui.screens.authscreens.Login
import com.yogesh.stylish.presentation.ui.screens.authscreens.ResetPassword
import com.yogesh.stylish.presentation.ui.screens.authscreens.SignUp
import com.yogesh.stylish.presentation.ui.screens.onboardingscreens.OnBoarding1
import com.yogesh.stylish.presentation.ui.screens.onboardingscreens.OnBoarding2
import com.yogesh.stylish.presentation.ui.screens.onboardingscreens.OnBoarding3

@Composable
fun Navigation() {

    val navController = rememberNavController()



    NavHost(navController = navController, startDestination = Routes.Splash) {

        composable<Routes.Splash> { Splash(navController) }

        composable<Routes.OnBoarding1> {
            OnBoarding1(navController)
        }
        composable<Routes.OnBoarding2> { OnBoarding2(navController) }
        composable<Routes.OnBoarding3> { OnBoarding3(navController) }

        composable<Routes.SignUp> {
            SignUp(navController)
        }

        composable<Routes.Login> {
            Login(navController)
        }

        composable<Routes.ForgotPassword> {
            ForgotPassword(navController)
        }

        composable<Routes.ResetPassword> { ResetPassword(navController) }

        composable<Routes.HomeScreen> { HomeScreen(navController) }


    }

}