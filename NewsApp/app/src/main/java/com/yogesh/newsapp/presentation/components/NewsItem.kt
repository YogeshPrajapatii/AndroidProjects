package com.yogesh.newsapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yogesh.newsapp.data.remote.dto.Article

// Wo extra function yahan se hata diya hai

@Composable
fun NewsItem(article: Article, onItemClick: (Article) -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 8.dp)
        // FIX #1: Yahan hum 'article' (object) pass kar rahe hain, 'Article' (class) nahi.
        .clickable { onItemClick(article) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        // FIX #2: Ek hi main Column rakha hai Card ke andar
        Column {
            AsyncImage(model = article.urlToImage,
                contentDescription = "News Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop)

            // Text wala Column ab main Column ke andar hai
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = article.source?.name ?: "Unknown Source",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = article.title ?: "No Title",
                    style = MaterialTheme.typography.titleMedium,
                    // Aapne color aur font weight change kiya, a-one lag raha hai!
                    color = Color.Cyan,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2)
            }
        }
    }
}