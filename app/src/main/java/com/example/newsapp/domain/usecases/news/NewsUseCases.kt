package com.example.newsapp.domain.usecases.news

//wrapper for all news cases in this package for easy DI in AppModule
data class NewsUseCases(
    val getNews: GetNews,
    val searchNews:SearchNews
)
