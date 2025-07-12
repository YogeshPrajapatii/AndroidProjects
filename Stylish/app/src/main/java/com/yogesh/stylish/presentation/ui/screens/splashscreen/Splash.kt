import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.yogesh.stylish.R
import com.yogesh.stylish.presentation.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavHostController) {

    LaunchedEffect(key1 = true) {
        delay(2000)

        navController.navigate(Routes.OnBoarding1)
    }



    Box(modifier = Modifier
        .fillMaxSize()
        .windowInsetsPadding(WindowInsets.statusBars)
        .background(Color.White), contentAlignment = Alignment.Center) {


        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {


            Image(painter = painterResource(id = R.drawable.splashscreen),
                contentDescription = "App Logo",
                modifier = Modifier.size(150.dp))

            Spacer(modifier = Modifier.height(10.dp))

            Text("Stylish", style = MaterialTheme.typography.headlineSmall)
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    val navController = rememberNavController()
    Splash(navController)
}
