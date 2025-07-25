package com.yogesh.newsapp.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.yogesh.newsapp.data.remote.dto.Article

@Composable
fun NewsList(news: List<Article>, onItemClick: (Article) -> Unit
) {
    LazyColumn {
        items(news) { article ->
            NewsItem(article = article,
                onItemClick = onItemClick) 
        }
    }
}
