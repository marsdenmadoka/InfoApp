package com.example.newsapp.Presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.newsapp.R

//hold each page information
data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

//list of pages for the onboarding screens
val pages = listOf(
    Page(

        title = "Current news",
        description = "breaking news, developing stories, politics, entertainment, lifestyle and much more ",
        image = R.drawable.onboarding2

    ),

    Page(

        title = "Business journalism",
        description = "Global Business and Financial News, Stock Quotes, and Market Data and Analysis. ",
        image = R.drawable.onboarding1

    ),
    Page(

        title = "Sports journalism",
        description = "Get all news coverage on different sports, from Cricket to Football,Tennis ",
        image = R.drawable.image1

    )
)
