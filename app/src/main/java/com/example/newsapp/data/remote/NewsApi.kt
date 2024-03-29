package com.example.newsapp.data.remote

import com.example.newsapp.data.remote.dto.NewsResponse
import com.example.newsapp.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
   //since we are using paging three library
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey:String = API_KEY
    ): NewsResponse

    //for our search functionality
    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey:String = API_KEY
    ): NewsResponse


}




