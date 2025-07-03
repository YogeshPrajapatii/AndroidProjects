package com.yogesh.cohort3/*
package com.yogesh.recomposition.cohort_3_assignments

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yogesh.myfirstcomposeapp.R


*/
/*In the Login screen, use a Box to center the form on the screen. Inside the box, use a Column to vertically arrange components like a title ("Login"), an Email TextField, a Password TextField, and a Row that contains a "Remember Me" checkbox and a "Forgot Password?" text. Finish with a Button labeled "Login".*//*


// Function to create login screen of my app
@Composable
fun LoginScreen() {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {


        Column(modifier = Modifier
            .fillMaxWidth(0.9f)
            .background(Color(0xFFEFEFEF), shape = RoundedCornerShape(12.dp))
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Image(painter = painterResource(R.drawable.app_logo),
                contentDescription = "App Icon",
                modifier = Modifier.height(75.dp),
                contentScale = ContentScale.Fit)



            Spacer(modifier = Modifier.height(10.dp))



            Text("Login",
                fontSize = 28.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold)


            Spacer(modifier = Modifier.height(15.dp))

            var enterEmail by rememberSaveable { mutableStateOf("") }
            OutlinedTextField(

                value = enterEmail,

                onValueChange = { enterEmail = it }, label = { Text("Enter your email") })

            Spacer(modifier = Modifier.height(10.dp))

            var enterPassword by rememberSaveable { mutableStateOf("") }

            OutlinedTextField(

                value = enterPassword,
                onValueChange = { enterPassword = it },
                label = { Text("Enter your password") }

            )

            Spacer(modifier = Modifier.height(15.dp))


            var checkStatus by rememberSaveable { mutableStateOf(false) }

            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = checkStatus,
                        onCheckedChange = { checkStatus = it },
                    )
                    Text("Remember me", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                }

                Text("Forgot Password ?", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }

            Spacer(modifier = Modifier.height(20.dp))


            Button(onClick = {}, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text("Login")
            }

        }
    }
}


*/
/*@Preview(showSystemUi = true)
@Composable
fun LoginPreview() {
    LoginScreen()
}*//*



*/
/*In the Sign-Up screen, use another Box to create a styled card layout. Inside it, arrange a 
Column with form fields for Name, Email, Password, and Confirm Password. Below these fields, 
place a Row with two buttons: "Cancel" and "Sign Up". Make sure the layout is neat, balanced, and responsive.*//*



// Function to create Sign Up Screen of my app
@Composable
fun SignUpScreen() {


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center


    ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFEFEFEF), shape = RoundedCornerShape(12.dp))
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text("Sign Up",
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic)

            Spacer(modifier = Modifier.height(15.dp))

            var userName by remember { mutableStateOf("") }
            OutlinedTextField(

                value = userName,
                onValueChange = { userName = it },
                label = { Text("Enter your name") })
            Spacer(modifier = Modifier.height(5.dp))
            var userEmail by remember { mutableStateOf("") }
            OutlinedTextField(

                value = userEmail,
                onValueChange = { userEmail = it },
                label = { Text("Enter your email") }

            )

            Spacer(modifier = Modifier.height(5.dp))
            var userPassword by remember { mutableStateOf("") }

            OutlinedTextField(

                value = userPassword,
                onValueChange = { userPassword = it },
                label = { Text("Enter Password") }

            )

            Spacer(modifier = Modifier.height(5.dp))

            var confirmPassword by remember { mutableStateOf("") }

            OutlinedTextField(value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") }

            )

            Spacer(modifier = Modifier.height(15.dp))

            Row() {

                Button(onClick = {}) {

                    Text("Cancel")
                }

                Spacer(modifier = Modifier.width(90.dp))

                Button(onClick = {}) {
                    Text("Sign Up")


                }
            }

        }

    }


}
*/
/*
@Preview(showSystemUi = true)
@Composable
fun SignUpPreview() {
    SignUpScreen()

}*//*
       */