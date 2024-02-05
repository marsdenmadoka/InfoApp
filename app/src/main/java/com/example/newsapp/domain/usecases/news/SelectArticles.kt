package com.example.newsapp.domain.usecases.news

import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article): Flow<List<Article>> {
       return newsDao.getArticles()
    }
}