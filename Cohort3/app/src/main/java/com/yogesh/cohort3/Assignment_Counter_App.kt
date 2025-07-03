package com.yogesh.cohort3/*
package com.yogesh.myfirstcomposeapp.cohort_3_assignments


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CounterApp() {

    var count by rememberSaveable { mutableIntStateOf(0) }

    Scaffold() {

        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {


            Text(count.toString(),
                fontSize = 100.sp,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic)

            Spacer(modifier = Modifier.height(50.dp))
            Row() {


                Button(onClick = {
                    count = count - 1
                }, modifier = Modifier.width(70.dp).height(50.dp)) { Text("-") }

                Spacer(modifier = Modifier.width(30.dp))

                Button(onClick = {
                    count = 0
                }, modifier = Modifier.width(100.dp).height(50.dp)) { Text("Reset") }


                Spacer(modifier = Modifier.width(30.dp))

                Button(onClick = {
                    count = count + 1
                }, modifier = Modifier.width(70.dp).height(50.dp)) {

                    Text("+")
                }


            }
        }

    }

}


@Composable
@Preview(showSystemUi = true)
fun CounterPreview() {
    CounterApp()
}*/
