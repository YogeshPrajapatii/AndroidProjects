package com.yogesh.cohort3.counterapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yogesh.cohort3.counterapp.viewmodel.CounterViewModel


@Composable
fun CounterApp(viewModel: CounterViewModel = viewModel()) {

    val count = viewModel.counter 

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("$count", fontSize = 80.sp)

        Spacer(modifier = Modifier.height(100.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            TextButton(onClick = { viewModel.IncNum() }) {
                Text("(+) Inc", fontSize = 24.sp)
            }
            TextButton(onClick = { viewModel.ResetNum() }) {
                Text("Reset", fontSize = 24.sp)
            }
            TextButton(onClick = { viewModel.DecNum() }) {
                Text("(-) Dec", fontSize = 24.sp)
            }
        }
    }
}



