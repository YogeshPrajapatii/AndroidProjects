package com.yogesh.stylish.presentation.ui.screens.authscreens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yogesh.stylish.presentation.navigation.Routes
import com.yogesh.stylish.ui.theme.Stylish

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPassword(navController: NavHostController) {


    val standardPadding = 16.dp
    var emailAddress by rememberSaveable { mutableStateOf("") }

    Scaffold(topBar = {

    }, bottomBar = {

    }, content = {

        Column(modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.statusBars)
            .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(standardPadding)) {


            Text(text = "Forgot\nPassword ?",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth())

            // Input Field
            OutlinedTextField(value = emailAddress, onValueChange = { emailAddress = it }, label = {
                Text("Enter your email", style = MaterialTheme.typography.bodyLarge)
            }, modifier = Modifier.fillMaxWidth())


            Text("* We will send you a message to\n reset your password.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth())


            ElevatedButton(
                onClick = { navController.navigate(Routes.ResetPassword) },
                colors = ButtonDefaults.elevatedButtonColors(containerColor = Stylish),
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Submit", style = MaterialTheme.typography.headlineSmall)
            }
        }
    })
}

@Preview(showSystemUi = true)
@Composable
fun ForPassPreview() {
    val navController = rememberNavController()
    ForgotPassword(navController)
}
