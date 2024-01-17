package com.example.newsapp.domain.manger

import kotlinx.coroutines.flow.Flow


interface LocalUserManger {
    //save the apps entry  when the user clicks the getStarted btn in onBoardingScreen

    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>

}