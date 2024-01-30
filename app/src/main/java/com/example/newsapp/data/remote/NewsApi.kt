package com.example.newsapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
//since we are using paging three library
        @Query("page") page: Int,
        @Query("sources") string: String,
        @Query("apiKey") apiKey:String
    )
}



