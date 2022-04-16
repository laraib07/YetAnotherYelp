package com.laraib07.yetanotheryelp.ui

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Result : Screen("result")
    object Detail : Screen("detail")
}
