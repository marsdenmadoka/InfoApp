package com.example.newsapp.Presentation.details

sealed class DetailsEvent {
    object UpsertDeleteArticle: DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}