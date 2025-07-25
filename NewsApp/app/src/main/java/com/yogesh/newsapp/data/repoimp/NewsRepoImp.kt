package com.yogesh.newsapp.data.repoimp

import com.yogesh.newsapp.data.apiservice.NewsApiService
import com.yogesh.newsapp.data.remote.dto.Article
import com.yogesh.newsapp.domain.repository.NewsRepo

class NewsRepoImp(private val newsApiService: NewsApiService) : NewsRepo {
    override suspend fun getNews(): List<Article> {
        return newsApiService.getNews()
    }


}