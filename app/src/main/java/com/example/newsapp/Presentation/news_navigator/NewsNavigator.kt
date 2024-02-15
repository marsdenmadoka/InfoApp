package com.example.newsapp.Presentation.news_navigator

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsapp.Presentation.Navgraph.Route
import com.example.newsapp.Presentation.home.HomeScreen
import com.example.newsapp.Presentation.home.HomeViewModel
import com.example.newsapp.Presentation.news_navigator.components.BottomNavigationItem
import com.example.newsapp.Presentation.news_navigator.components.NewsBottomNavigation
import com.example.newsapp.R

@Composable
fun NewsNavigator() {

    val bottomNavigationItems = remember {
        listOf(
            BottomNavigationItem(icon = R.drawable.ic_home, text = "Home"),
            BottomNavigationItem(icon = R.drawable.ic_search, text = "Search"),
            BottomNavigationItem(icon = R.drawable.ic_bookmark, text = "Bookmark"),

            )
    }


    val navController = rememberNavController()

    val backstackState = navController.currentBackStackEntryAsState().value
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }

    selectedItem = when (backstackState?.destination?.route) {
        Route.HomeScreen.route -> 0
        Route.SearchScreen.route -> 1
        Route.BookmarkScreen.route -> 2
        else -> 0
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NewsBottomNavigation(
                items = bottomNavigationItems,
                selected = selectedItem,
                onItemClick = { index ->

                    when (index) {
                        0 -> navigateToTap(
                            navController = navController,
                            route = Route.HomeScreen.route
                        )

                        1 -> navigateToTap(
                            navController = navController,
                            route = Route.SearchScreen.route
                        )

                        2 -> navigateToTap(
                            navController = navController,
                            route = Route.BookmarkScreen.route
                        )

                    }
                })
        }
    ) {
        val bottomPadding = it.calculateBottomPadding()
        NavHost(
            navController = navController,
            startDestination = Route.HomeScreen.route,
            modifier = Modifier.padding(bottom = bottomPadding)
        )
        {
            composable(route = Route.HomeScreen.route){
                val viewModel: HomeViewModel= hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()
                HomeScreen(
                    articles = articles,
                    navigateToSearch = {
                        navigateToTap(navController = navController, route = Route.SearchScreen.route)
                    },
                    navigateToDetails = {
                        navigateToTap(navController = navController, route = Route.DetailsScreen.route)
                    }

                )
            }
        }


    }
}


fun navigateToTap(navController: NavController, route: String) {

    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { homescreen ->
            popUpTo(homescreen) {
                saveState = true
            }
            restoreState = true
            launchSingleTop = true
        }
    }
}