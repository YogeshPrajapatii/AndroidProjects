package com.yogesh.focuslogger


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yogesh.focuslogger.ui.theme.FocusLoggerTheme
import com.yogesh.focuslogger.ui.theme.mainscreens.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FocusLoggerTheme {
                HomeScreen()
            }
            }
        }
    }