package com.yogesh.newsapp.domain.repository

import com.yogesh.newsapp.data.remote.dto.Article

interface NewsRepo {

    suspend fun getNews():List<Article>
    
}