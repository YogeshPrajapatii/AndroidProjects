package com.yogesh.stylish.presentation.ui.screens.authscreens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yogesh.stylish.R
import com.yogesh.stylish.presentation.navigation.Routes
import com.yogesh.stylish.ui.theme.Stylish

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavHostController) {

    var standardPadding = 16.dp
    var userId by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    Scaffold(


        topBar = {

            /* TopAppBar(title = { Text("Login") })*/
        },

        bottomBar = {
            /* BottomAppBar {
                 Text("E - Commerce App")
             }*/
        },

        content = {/* innerPadding ->*/

            Column(modifier = Modifier
                .fillMaxWidth()/* .padding(innerPadding),*/
                .padding(horizontal = 24.dp)
                .windowInsetsPadding(WindowInsets.statusBars),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(standardPadding)) {


                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                    horizontalAlignment = Alignment.Start

                ) {
                    Text("Welcome \nBack !", style = MaterialTheme.typography.headlineLarge)
                }

                OutlinedTextField(

                    value = userId, onValueChange = {

                        userId = it
                    }, label = { Text("Username or Email") }, modifier = Modifier.fillMaxWidth()

                )

                OutlinedTextField(

                    value = password, onValueChange = {
                        password = it
                    }, label = { Text("Password") }, modifier = Modifier.fillMaxWidth()

                )

                Text("Forgot Password ?",
                    modifier = Modifier
                        .clickable { navController.navigate(Routes.ForgotPassword) }
                        .fillMaxWidth()
                        .padding(end = 55.dp),
                    textAlign = TextAlign.End,
                    color = Color.Red)

                ElevatedButton(onClick = {

                    if (userId.isBlank() || password.isBlank()) {

                        Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    } else {
                        navController.navigate(Routes.HomeScreen)
                    }


                },
                    colors = ButtonDefaults.elevatedButtonColors(containerColor = Stylish),
                    modifier = Modifier.fillMaxWidth()) {

                    Text("Login")

                }


                Text("- or continue with -")

                Row(modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {

                    IconButton(onClick = {}) {
                        Image(painter = painterResource(id = R.drawable.google),
                            contentDescription = "Google Logo",
                            Modifier.size(40.dp))
                    }
                    IconButton(onClick = {}) {
                        Image(painter = painterResource(id = R.drawable.apple),
                            contentDescription = "Apple Logo",
                            modifier = Modifier.size(40.dp))
                    }
                    IconButton(onClick = {}) {
                        Image(painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "FaceBook Logo",
                            Modifier.size(40.dp))
                    }
                }

                Row() {
                    Text("Create an account ")
                    Text("Sign Up",
                        modifier = Modifier.clickable { navController.navigate(Routes.SignUp) },
                        color = Color.Blue)
                }

            }


        })


}

@Preview(showSystemUi = true)
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    Login(navController)
}
