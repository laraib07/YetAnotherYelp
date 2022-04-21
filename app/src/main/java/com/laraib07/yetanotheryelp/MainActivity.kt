package com.laraib07.yetanotheryelp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.laraib07.yetanotheryelp.ui.MainScreen
import com.laraib07.yetanotheryelp.ui.appbar.SearchViewModel

class MainActivity : ComponentActivity() {

    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(searchViewModel = searchViewModel)
        }
    }
}