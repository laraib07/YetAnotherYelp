package com.laraib07.yetanotheryelp.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.laraib07.yetanotheryelp.ui.appbar.SearchViewModel
import com.laraib07.yetanotheryelp.ui.detail.DetailScreen
import com.laraib07.yetanotheryelp.ui.result.ResultScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
    searchViewModel: SearchViewModel
) {
    val sharedViewModel: SharedViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.Result.route
    ) {
        composable(route = Screen.Result.route) {
            ResultScreen(
                searchViewModel = searchViewModel,
                sharedViewModel = sharedViewModel,
                navController = navController
            )
        }
        composable(route = Screen.Detail.route) {
            DetailScreen(
                sharedViewModel = sharedViewModel,
            )
        }
    }
}