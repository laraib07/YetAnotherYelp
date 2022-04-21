package com.laraib07.yetanotheryelp.ui.result

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.laraib07.yetanotheryelp.api.YelpApiStatus
import com.laraib07.yetanotheryelp.ui.SharedViewModel
import com.laraib07.yetanotheryelp.ui.appbar.SearchViewModel

@Composable
fun ResultScreen(
    searchViewModel: SearchViewModel,
    sharedViewModel: SharedViewModel,
    navController: NavHostController
) {
    val status by searchViewModel.status
    val queryState by searchViewModel.queryState
    LaunchedEffect(key1 = queryState) {
        if(searchViewModel.businessList.isEmpty()) {
            searchViewModel.getBusiness(queryState)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when(status) {
            YelpApiStatus.LOADING -> {
                AnimatedShimmer()
            }
            YelpApiStatus.DONE -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    itemsIndexed(items = searchViewModel.businessList) { _, business ->
                        BusinessItem(
                            business = business,
                            navController = navController,
                            sharedViewModel = sharedViewModel
                        )
                    }
                }
            }
            YelpApiStatus.ERROR -> {
                ErrorScreen()
            }
        }
    }
}