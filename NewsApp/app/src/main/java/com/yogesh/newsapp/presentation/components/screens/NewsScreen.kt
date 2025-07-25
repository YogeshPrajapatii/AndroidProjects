// com.yogesh.newsapp.presentation/NewsScreen.kt

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.yogesh.newsapp.data.remote.dto.Article
import com.yogesh.newsapp.presentation.components.viewmodel.NewsViewModel
import com.yogesh.newsapp.presentation.components.NewsList
import com.yogesh.newsapp.util.NewsResult

@Composable
fun NewsScreen(viewModel: NewsViewModel) {
    val newsState = viewModel.newsState.collectAsState()

    // API कॉल को सिर्फ एक बार ट्रिगर करने के लिए LaunchedEffect का इस्तेमाल करें
    LaunchedEffect(key1 = Unit) {
        viewModel.getNews()
    }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center // सभी चीजों को सेंटर में लाएगा
    ) {
        when (val result = newsState.value) {
            is NewsResult.Loading -> {
                CircularProgressIndicator() // अब यह सेंटर में दिखेगा
            }

            is NewsResult.Error -> {
                Text(text = result.message ?: "Unknown error occurred!")
            }

            is NewsResult.Success<*> -> {
                NewsList(news = result.data as List<Article>)
            }

            is NewsResult.Idle -> {
                // Idle state में कुछ भी दिखाने की जरूरत नहीं है, क्योंकि LaunchedEffect कॉल हैंडल कर रहा है
            }
        }
    }
}