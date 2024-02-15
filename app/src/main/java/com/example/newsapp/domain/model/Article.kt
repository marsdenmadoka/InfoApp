package com.example.newsapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize //since we want to pass this object to the details screen
@Entity
data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,// We can only save primitive data types in room and not objects therefore we have to convert this in object using type converters
    val title: String,
    @PrimaryKey val url: String,
    val urlToImage: String
):Parcelable