package com.example.newsapp.Presentation.search

import androidx.paging.PagingData
import com.example.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery:String = "",
    val articles:Flow<PagingData<Article>>? = null
) {
}