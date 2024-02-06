package com.example.newsapp.domain.usecases.news

//wrapper for all news cases in this package for easy DI in AppModule
data class NewsUseCases(
    //remote use
    val getNews: GetNews,
    val searchNews:SearchNews,


    //for local db
    val selectArticle: SelectArticle,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
     val selectArticles: SelectArticles

)
