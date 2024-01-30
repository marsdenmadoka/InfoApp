package com.example.newsapp.domain.usecases.app_entry

//for proving our di
data class AppEntryUseCases(
    val readAppEntry: ReadAppEntry,
    val saveAppEntry: SaveAppEntry
)
