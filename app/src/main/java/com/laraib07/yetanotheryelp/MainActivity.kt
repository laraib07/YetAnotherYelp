package com.laraib07.yetanotheryelp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.laraib07.yetanotheryelp.ui.MainNavGraph
import com.laraib07.yetanotheryelp.ui.MainScreen
import com.laraib07.yetanotheryelp.ui.appbar.SearchViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainNavGraph()
        }
    }
}