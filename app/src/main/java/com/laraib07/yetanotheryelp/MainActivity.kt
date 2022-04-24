package com.laraib07.yetanotheryelp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.laraib07.yetanotheryelp.ui.MainNavGraph
import com.laraib07.yetanotheryelp.ui.MainScreen
import com.laraib07.yetanotheryelp.ui.appbar.SearchViewModel
import com.laraib07.yetanotheryelp.ui.theme.YetAnotherYelpTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YetAnotherYelpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainNavGraph()
                }
            }
        }
    }
}