package com.example.newsapp.Presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
):ViewModel(){

    fun onEvent(event:OnBoardingEvent){ //combination between mvi and mvvm to using our viewModels direct in  our screen || we just expose the event to the outside
        when(event){
            is OnBoardingEvent.SaveAppEntry ->{
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry(){
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }

    }

}