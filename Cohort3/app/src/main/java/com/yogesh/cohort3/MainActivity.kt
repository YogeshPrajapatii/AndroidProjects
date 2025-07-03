package com.yogesh.cohort3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yogesh.cohort3.counterapp.view.CounterApp
import com.yogesh.cohort3.ui.theme.Cohort3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cohort3Theme {
                CounterApp()
            }
        }
    }
}
