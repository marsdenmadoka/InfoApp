package com.example.newsapp.Presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.newsapp.Presentation.onboarding.components.OnboardingPage

@OptIn(ExperimentalFoundationApi::class)
@Composable
//combine onboaradingpage and pageindicator and button
fun OnBoardingScreen() {
    Column(modifier = Modifier.fillMaxSize()) {//paging
        val pagerState = rememberPagerState(
            initialPage = 0){
            pages.size
        }


        val buttonState = remember {
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> listOf("","Next")
                    1 -> listOf("Back","Next")
                    2 -> listOf("Back","Get Started")
                    else -> listOf("")

                }
            }
        }
        
        
        HorizontalPager(state = pagerState) { index->
            OnboardingPage(page = pages[index])
            
        }
        

    }
}