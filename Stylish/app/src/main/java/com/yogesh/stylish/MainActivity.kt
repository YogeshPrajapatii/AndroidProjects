package com.yogesh.stylish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yogesh.stylish.presentation.navigation.Navigation
import com.yogesh.stylish.presentation.ui.theme.MyFirstComposeAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyFirstComposeAppTheme {


                Navigation()


            }
        }
    }
}

