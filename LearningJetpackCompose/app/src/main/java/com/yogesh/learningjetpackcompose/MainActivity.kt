package com.yogesh.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yogesh.learningjetpackcompose.core_concepts_3.SimpleOutLinedTextField
import com.yogesh.learningjetpackcompose.fundamental_concepts_2.Greet
import com.yogesh.learningjetpackcompose.fundamental_concepts_2.ResourceAccess
import com.yogesh.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningJetpackComposeTheme {
                //ResourceAccess()

               // SimpleOutLinedTextField()
                }
            }
        }
    }


