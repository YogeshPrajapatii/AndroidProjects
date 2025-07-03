package com.yogesh.learningjetpackcompose.core_concepts_3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SimpleOutLinedTextField() {

    var text by remember {
        mutableStateOf("")
    }

    val rainbowColors = listOf(
        Color.Black,
        Color.DarkGray,
        Color.Blue,
        Color.Green,
        Color.Magenta,
        Color.Yellow,
        Color.White,
    )

    val brush = remember {
        Brush.linearGradient(colors = rainbowColors)
    }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {


        TextField(value = text, onValueChange = {
            text = it
        }, textStyle = TextStyle(brush = brush))


        /* OutlinedTextField(value = text, onValueChange = {
 
             text = it
         }, label = { Text("Sample Liable") })*/


    }
}


// Text with Password

@Composable
fun TextWithPassword() {


    var password by rememberSaveable {

        mutableStateOf("")
    }

    TextField(

        value = password,
        onValueChange = {
            password = it
        },


        label = {
            Text("Enter Password")

        },

        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardType.Password


    )

}

@Preview
@Composable
fun P() {
    SimpleOutLinedTextField()
}


@Preview(showSystemUi = true)
@Composable
fun PreviewDemo() {
//    SimpleOutLinedTextField()
}

