package com.yogesh.stylish.presentation.ui.screens.authscreens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavHostController) {

    val context = LocalContext.current

    // AuthViewModel ko inject kar rahe hain factory ke through
    val authViewModel: AuthViewModel =
        viewModel(factory = AuthViewModelFactory(loginUseCase = LoginUseCase(AuthRepositoryImpl()),
            signUpUseCase = SignUpUseCase(AuthRepositoryImpl())))

    // UI state variables
    var userId by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    // Auth State ko observe kar rahe hain ViewModel se
    val authState by authViewModel.authState.collectAsState()

    // Loading state button ke liye
    val isLoading = authState is Result.Loading

    // authState ke response ke hisaab se UI react karega
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
            is Result.Success -> {
                // Login success hone par Home screen pe navigate karo
                navController.navigate(Routes.HomeScreen) {
                    popUpTo(Routes.Login) { inclusive = true } // Backstack clear
                }
            }
            
        }
    }

    Scaffold(content = {
        // Parent Box for vertical centering
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(24.dp) // Thoda sa padding har taraf
            .windowInsetsPadding(WindowInsets.statusBars),
            contentAlignment = Alignment.Center // Center the entire column
        ) {

            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)) {

                // Welcome Text
                Text("Welcome \nBack!",
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp))

                // Username / Email TextField
                OutlinedTextField(value = userId,
                    onValueChange = { userId = it },
                    label = { Text("Username or Email") },
                    modifier = Modifier.fillMaxWidth())

                // Password TextField
                OutlinedTextField(value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    modifier = Modifier.fillMaxWidth())

                // Forgot Password Text
                Text("Forgot Password?",
                    modifier = Modifier
                        .clickable { navController.navigate(Routes.ForgotPassword) }
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    textAlign = TextAlign.End,
                    color = Color.Red)

                // Login Button with loading indicator
                Button(onClick = {
                    if (userId.isNotBlank() && password.isNotBlank()) {
                        authViewModel.login(userId, password)
                    } else {
                        Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                    }
                },
                    colors = ButtonDefaults.buttonColors(containerColor = Stylish),
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.small // 👈 Rectangle corners
                ) {
                    if (isLoading) {
                        // Circular progress indicator jab Loading state hai
                        CircularProgressIndicator(color = Color.White,
                            modifier = Modifier.size(20.dp),
                            strokeWidth = 2.dp)
                    } else {
                        Text("Login")
                    }
                }

                // OR Divider
                Text("- or continue with -")

                // Social Login Row
                Row(modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    SocialLoginButton(R.drawable.google, "Google")
                    SocialLoginButton(R.drawable.apple, "Apple")
                    SocialLoginButton(R.drawable.facebook, "Facebook")
                }

                // Sign Up Text
                Row {
                    Text("Create an account ")
                    Text("Sign Up", modifier = Modifier.clickable {
                        navController.navigate(Routes.SignUp)
                    }, color = Color.Blue)
                }
            }
        }
    })
}

// Social Login Button Composable for reuse
@Composable
fun SocialLoginButton(iconRes: Int, contentDescription: String) {
    IconButton(onClick = { /* TODO: Social login logic */ }) {
        Image(painter = painterResource(id = iconRes),
            contentDescription = contentDescription,
            modifier = Modifier.size(40.dp))
    }
}
