package com.laraib07.yetanotheryelp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.laraib07.yetanotheryelp.ui.MainScreen
import com.laraib07.yetanotheryelp.ui.home.HomeScreen
import com.laraib07.yetanotheryelp.ui.home.SearchWidgetViewModel
import com.laraib07.yetanotheryelp.ui.theme.YetAnotherYelpTheme

class MainActivity : ComponentActivity() {

    private val searchViewModel: SearchWidgetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(searchViewModel = searchViewModel)
        }
    }
}