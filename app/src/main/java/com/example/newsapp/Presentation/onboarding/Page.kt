package com.example.newsapp.Presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(

        title = "Lorem Ipsum is Simple",
        description = "Lorem Ipsum is Simple dummy text of the printing and typesetting",
        image = R.drawable.onboarding1

    ),

    Page(

        title = "Lorem Ipsum is Simple",
        description = "Lorem Ipsum is Simple dummy text of the printing and typesetting",
        image = R.drawable.onboarding1

    ),
    Page(

        title = "Lorem Ipsum is Simple",
        description = "Lorem Ipsum is Simple dummy text of the printing and typesetting",
        image = R.drawable.onboarding1

    )
)
