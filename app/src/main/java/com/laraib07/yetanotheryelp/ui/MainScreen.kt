package com.laraib07.yetanotheryelp.ui

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.laraib07.yetanotheryelp.ui.appbar.AppBar
import com.laraib07.yetanotheryelp.ui.appbar.SearchWidgetState
import com.laraib07.yetanotheryelp.ui.appbar.SearchViewModel
import com.laraib07.yetanotheryelp.ui.result.ResultScreen
import com.laraib07.yetanotheryelp.ui.theme.YetAnotherYelpTheme

@Composable
fun MainScreen(
    searchViewModel: SearchViewModel,
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val searchWidgetState by searchViewModel.searchWidgetState
    val searchTextState by searchViewModel.searchTextState

    YetAnotherYelpTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                topBar = {
                    AppBar(
                        searchWidgetState = searchWidgetState,
                        searchTextState = searchTextState,
                        onTextChange = {
                            searchViewModel.updateSearchTextState(newValue = it)
                        },
                        onCloseClicked = {
                            searchViewModel.updateSearchWidgetState(SearchWidgetState.CLOSED)
                        },
                        onSearchClicked = {
                            Log.d("SearchClicked", it)
                            if(searchTextState != searchViewModel.queryState.value) {
                                searchViewModel.businessList = ArrayList()
                            }
                            searchViewModel.updateQueryState(newValue = it)
                            searchViewModel.updateSearchWidgetState(SearchWidgetState.CLOSED)
                        },
                        onSearchTriggered = {
                            searchViewModel.updateSearchTextState("")
                            searchViewModel.updateSearchWidgetState(SearchWidgetState.OPENED)
                        }
                    )
                },
            ) {
                ResultScreen(
                    searchViewModel = searchViewModel,
                    sharedViewModel = sharedViewModel,
                    navController = navController
                )
            }
        }
    }
}