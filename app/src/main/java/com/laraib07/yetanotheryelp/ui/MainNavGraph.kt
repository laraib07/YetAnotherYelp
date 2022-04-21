package com.laraib07.yetanotheryelp.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.laraib07.yetanotheryelp.ui.appbar.SearchViewModel
import com.laraib07.yetanotheryelp.ui.detail.DetailScreen
import com.laraib07.yetanotheryelp.ui.result.ResultScreen

@Composable
fun MainNavGraph() {
    val sharedViewModel: SharedViewModel = viewModel()
    val searchViewModel: SearchViewModel = viewModel()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Result.route
    ) {
        composable(route = Screen.Result.route) {
            MainScreen(
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