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
import androidx.compose.runtime.remember
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


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUp(navController: NavHostController) {
    var userId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val standardSpacing = 16.dp
    val context = LocalContext.current

    Scaffold(topBar = {

        /*TopAppBar(title = {Text("Sign Up") })*/


    }, bottomBar = {
        /*BottomAppBar {

            Text("E - Commerce App",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.End)

        }*/

    }, content = { /*innerPadding ->*/
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .windowInsetsPadding(WindowInsets.statusBars),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(standardSpacing)) {


            Text(text = "Create an\naccount",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Left,
                style = MaterialTheme.typography.titleLarge)


            OutlinedTextField(

                value = userId,
                onValueChange = {
                    userId = it
                },
                label = { Text("Username of Email", style = MaterialTheme.typography.bodyLarge) },
                modifier = Modifier.fillMaxWidth())

            OutlinedTextField(

                value = password, onValueChange = {
                    password = it
                }, label = {
                    Text("Password", style = MaterialTheme.typography.bodyLarge)
                }, modifier = Modifier.fillMaxWidth()

            )

            OutlinedTextField(


                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password", style = MaterialTheme.typography.bodyLarge) },
                modifier = Modifier.fillMaxWidth())


            ElevatedButton(onClick = {


                if (userId.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                    Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()

                } else {
                    navController.navigate(Routes.Login)
                }


            },
                colors = ButtonDefaults.elevatedButtonColors(containerColor = Stylish),
                modifier = Modifier.fillMaxWidth()) {
                Text("Create Account", style = MaterialTheme.typography.titleLarge)
            }

            Text("- Or continue with -", style = MaterialTheme.typography.bodyLarge)

            Row(horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically) {

                IconButton(onClick = {}) {

                    Image(

                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google Logo",
                        modifier = Modifier.size(40.dp)

                    )
                }

                IconButton(onClick = {}) {

                    Image(painter = painterResource(id = R.drawable.apple),
                        contentDescription = "Apple Logo",
                        modifier = Modifier.size(40.dp))


                }
                IconButton(onClick = {}) {

                    Image(

                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "FaceBook Logo",
                        modifier = Modifier.size(40.dp))

                }

            }


            Row() {
                Text("I have already an account, ", style = MaterialTheme.typography.bodyLarge)
                Text("Login",
                    modifier = Modifier.clickable { navController.navigate(Routes.Login) },
                    color = Color.Blue,
                    style = MaterialTheme.typography.bodyLarge)
            }
        }
    })

}

@Preview(showSystemUi = true)
@Composable
fun SignUpPreview() {
    val navController = rememberNavController()
    SignUp(navController)
}
