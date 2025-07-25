package com.yogesh.newsapp.presentation.components.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogesh.newsapp.data.remote.dto.Article
import com.yogesh.newsapp.domain.repository.NewsRepo
import com.yogesh.newsapp.util.NewsResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepo: NewsRepo) : ViewModel() {

    private val _newsState = MutableStateFlow<NewsResult<List<Article>>>(NewsResult.Idle)
    public val newsState: StateFlow<NewsResult<List<Article>>> = _newsState

    val errorMessage = mutableStateOf<String?>(null)

    fun getNews() {

        viewModelScope.launch {

            _newsState.value = NewsResult.Loading

            try {
                val response = newsRepo.getNews()
                _newsState.value = NewsResult.Success(response)


            } catch (e: Exception) {
                errorMessage.value = "Something went wrong"

                _newsState.value = NewsResult.Error(errorMessage.value)

            }


        }

    }

}