package com.example.newsapp.Presentation.bookmark

import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.usecases.news.SelectArticles


//book not form remote we are creating it local
data class BookmarkState(
    val articles: List<Article> = emptyList()

)