package com.example.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsapp.domain.model.Article

//for paging
class NewsPagingSource(
    private val newsApi: NewsApi,
    private val sources: String
):PagingSource<Int,Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        TODO("Not yet implemented")
    }


}