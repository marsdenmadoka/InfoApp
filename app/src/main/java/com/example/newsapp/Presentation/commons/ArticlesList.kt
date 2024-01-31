package com.example.newsapp.Presentation.commons

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.newsapp.Presentation.Dimes.ExtraSmallpadding
import com.example.newsapp.Presentation.Dimes.MediumPadding1
import com.example.newsapp.domain.model.Article

@Composable
//showing list of articles we get //this composable will also be used in multiple screens eg searchscreen
fun ArticlesList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,//recyclerViewer
    onClick:(Article) -> Unit
) {
    val handlePagingResult = handlePagingResult(articles = articles)
    if(handlePagingResult){
        LazyColumn(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallpadding)
        ){
            items(count =articles.itemCount) {
                articles[it]?.let{
                    ArticleCard(article = it, onClick = {onClick(it)})


                }
            }
        }
    }
}

@Composable
fun handlePagingResult( articles: LazyPagingItems<Article>):Boolean {
    val loadState = articles.loadState
  val error = when{
      loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
      loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
      loadState.append is LoadState.Error -> loadState.append as LoadState.Error
      else -> null
  }

    return when {
        loadState.refresh is LoadState.Loading ->{
       ShimmerEffect()
            false
        }
        error !=null ->{
            EmptyScreen()
            false
        }else -> {
            true
        }
    }
}

@Composable
private fun ShimmerEffect(){
    Column (verticalArrangement = Arrangement.spacedBy(MediumPadding1)){
       repeat(10){
           ArticleCardShimmerEffect(
               modifier = Modifier.padding(horizontal = MediumPadding1 )
           )
       }
    }
}






