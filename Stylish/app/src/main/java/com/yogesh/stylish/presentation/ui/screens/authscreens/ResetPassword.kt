package com.yogesh.stylish.presentation.ui.screens.authscreens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yogesh.stylish.presentation.navigation.Routes
import com.yogesh.stylish.ui.theme.Stylish

@Composable
fun ResetPassword(navController: NavHostController) {


    var newPassword by remember { mutableStateOf("") }
    val standardSpacing = 16.dp
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .windowInsetsPadding(WindowInsets.statusBars),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(standardSpacing),
    ) {


        Text(text = "Reset your password",
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Left,
            style = MaterialTheme.typography.headlineLarge)

        OutlinedTextField(

            value = newPassword, onValueChange = {
                newPassword = it
            }, label = {
                Text("New Password", style = MaterialTheme.typography.bodyLarge)
            }, modifier = Modifier.fillMaxWidth()

        )

        OutlinedTextField(


            value = newPassword,
            onValueChange = { newPassword = it },
            label = { Text("Confirm Password", style = MaterialTheme.typography.bodyLarge) },
            modifier = Modifier.fillMaxWidth())


        ElevatedButton(onClick = {

            if (newPassword.isBlank()) {

                Toast.makeText(context, "Please enter your password !", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(context, "Password Changed", Toast.LENGTH_SHORT).show()
                navController.navigate(Routes.Login)
            }


        },
            colors = ButtonDefaults.elevatedButtonColors(containerColor = Stylish),
            modifier = Modifier.fillMaxWidth()) {
            Text("Change Password", style = MaterialTheme.typography.titleLarge)
        }


    }
}
