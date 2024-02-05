package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.Presentation.Navgraph.NavGraph
import com.example.newsapp.data.local.NewsDao
import com.example.newsapp.ui.theme.NewsAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // @Inject
    //  lateinit var appEntryUseCases:AppEntryUseCases //for tests

    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)//drawing screen behind system bars


        installSplashScreen().apply { //keep splash screen visible until we fetch startDestination from preferences
            setKeepOnScreenCondition {
                viewModel.splashCondition

            }
        }


        /* lifecycleScope.launch {
                 //testing if our di works
                 appEntryUseCases.readAppEntry().collect{
                     Log.d("test",it.toString())
                 } */

        setContent {
            NewsAppTheme {

                val isSystemInDarkMode = isSystemInDarkTheme()
                val systemController = rememberSystemUiController()

                SideEffect {
                    systemController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = !isSystemInDarkMode
                    )
                }

                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)
                    /* val viewModel: OnBoardingViewModel = hiltViewModel()
                      OnBoardingScreen(
                          event = viewModel::onEvent
                      )*/
                }


            }
        }
    }
}
