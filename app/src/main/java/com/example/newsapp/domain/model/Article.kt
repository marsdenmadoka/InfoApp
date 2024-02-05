package com.example.newsapp.domain.model

import androidx.room.Entity

@Entity
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
  val source: Source,// We can only save primitive data types in room and not objects therefore we have to convert this in object using type converters
    val title: String,
    val url: String,
    val urlToImage: String
)