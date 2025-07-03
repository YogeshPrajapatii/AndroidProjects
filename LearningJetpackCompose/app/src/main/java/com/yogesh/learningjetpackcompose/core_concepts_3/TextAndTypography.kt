package com.yogesh.learningjetpackcompose.core_concepts_3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun TextExample() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Text("Hi Jetpack Compose",

            style = TextStyle(color = Color.Cyan,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                shadow = Shadow(color = Color.Black, blurRadius = 15f)))
    }
}


@Composable
fun TextExample2() {
    val rainBowColors = listOf(

        Color.Black,
        Color.DarkGray,
        Color.Blue,
        Color.Green,
        Color.Magenta,
        Color.Yellow,
        Color.White

    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(

            text = buildAnnotatedString {
                append("Don't care what other people saying \n Just keep " + "working towards success ")
                withStyle(SpanStyle(brush = Brush.linearGradient(colors = rainBowColors))

                ) {

                    append("\nKeep focusing on your work")
                }

                append("\nYou will become successfull in next 2 years")
            })
    }
}

@Composable
fun ScrollableText() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Hi i am a full stack android developer".repeat(10),
            // modifier = Modifier.basicMarquee(),
            fontSize = 40.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1

        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun Preview() {
//    TextExample()

//    TextExample2()

//    ScrollableText()


}