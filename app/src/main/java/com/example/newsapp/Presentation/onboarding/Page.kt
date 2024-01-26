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

        title = "Lorem Ipsum is Simple",
        description = "Lorem Ipsum is Simple dummy text of the printing and typesetting",
        image = R.drawable.image1

    ),

    Page(

        title = "Lorem Ipsum is Simple",
        description = "Lorem Ipsum is Simple dummy text of the printing and typesetting",
        image = R.drawable.image5

    ),
    Page(

        title = "Lorem Ipsum is Simple",
        description = "Lorem Ipsum is Simple dummy text of the printing and typesetting",
        image = R.drawable.image4

    )
)
