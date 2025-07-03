package com.yogesh.learningjetpackcompose.fundamental_concepts_2

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

// Composable Function

@Composable
fun Greet() {
    Text(text = "Hello Jetpack Compose , I am Yogesh Varma")
}

@Preview(showSystemUi = true)
@Composable
fun ComposePreview(){
    Greet()
} 