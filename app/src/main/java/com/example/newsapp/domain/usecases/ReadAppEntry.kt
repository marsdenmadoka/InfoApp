package com.example.newsapp.domain.usecases

import com.example.newsapp.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManger
) {
    suspend operator fun invoke():Flow<Boolean> {
       return localUserManger.readAppEntry()
    }
}