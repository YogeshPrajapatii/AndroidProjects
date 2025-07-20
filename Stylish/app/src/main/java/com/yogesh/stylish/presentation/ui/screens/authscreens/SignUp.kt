package com.yogesh.stylish.presentation.ui.screens.authscreens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.yogesh.stylish.R
import com.yogesh.stylish.data.repositoryimp.AuthRepositoryImpl
import com.yogesh.stylish.domain.usecase.LoginUseCase
import com.yogesh.stylish.domain.usecase.SignUpUseCase
import com.yogesh.stylish.domain.util.Result
import com.yogesh.stylish.presentation.navigation.Routes
import com.yogesh.stylish.ui.theme.Stylish

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignUp(navController: NavHostController) {

    val context = LocalContext.current

    // 📝 AuthViewModel ko factory ke through initialize kar rahe hain
    val authViewModel: AuthViewModel =
        viewModel(factory = AuthViewModelFactory(
            loginUseCase = LoginUseCase(AuthRepositoryImpl()),
            signUpUseCase = SignUpUseCase(AuthRepositoryImpl())
        ))

    // 📝 UI ke liye mutable state variables
    var userId by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    // 📝 ViewModel se authState observe kar rahe hain
    val authState by authViewModel.authState.collectAsState()
    val isLoading = authState is Result.Loading // ✅ Loading indicator ka state

    /**
     * 🔥 LaunchedEffect ka use kar rahe hain taaki jaise hi authState change ho
     * hum response ke hisaab se UI update kar saken
     */
    LaunchedEffect(authState) {
        when (val currentState = authState) {
            is Result.Failure -> {
                showError = true
                errorMessage = currentState.message
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }

            Result.Ideal, Result.Loading -> {
                showError = false
            }

            is Result.Success<*> -> {
                // 📝 SignUp successful hone par HomeScreen pe navigate karo
                navController.navigate(Routes.Login) {
                    popUpTo(Routes.SignUp) { inclusive = true } // Backstack clear
                }
            }
        }
    }

    Scaffold(content = {
        // 🔥 Box for vertical centering of screen content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .windowInsetsPadding(WindowInsets.statusBars),
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp) // 📝 Standard vertical spacing
            ) {

                // 📝 Heading Text
                Text(
                    text = "Create an\nAccount",
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                )

                // 📝 Username / Email TextField
                OutlinedTextField(
                    value = userId,
                    onValueChange = { userId = it },
                    label = { Text("Username or Email") },
                    modifier = Modifier.fillMaxWidth()
                )

                // 📝 Password TextField
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth()
                )

                // 📝 Sign Up Button with loading indicator
                Button(
                    onClick = {
                        if (userId.isNotBlank() && password.isNotBlank()) {
                            authViewModel.signup(userId, password)
                        } else {
                            Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Stylish),
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.small // 🔲 Rectangle button corners
                ) {
                    if (isLoading) {
                        // 📝 Show loader while signup API is working
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier.size(20.dp),
                            strokeWidth = 2.dp
                        )
                    } else {
                        Text("Sign Up")
                    }
                }

                // 📝 Divider Text
                Text("- or continue with -", style = MaterialTheme.typography.bodyLarge)

                // 📝 Social Login Row (Google, Apple, Facebook)
                Row(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* TODO: Google login */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "Google Logo",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    IconButton(onClick = { /* TODO: Apple login */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.apple),
                            contentDescription = "Apple Logo",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    IconButton(onClick = { /* TODO: Facebook login */ }) {
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "Facebook Logo",
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }

                // 📝 Navigation to Login Screen
                Row {
                    Text("I already have an account, ", style = MaterialTheme.typography.bodyLarge)
                    Text(
                        "Login",
                        modifier = Modifier.clickable {
                            navController.navigate(Routes.Login)
                        },
                        color = Color.Blue,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    })
}
