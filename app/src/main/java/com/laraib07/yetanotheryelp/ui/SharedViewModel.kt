package com.laraib07.yetanotheryelp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.laraib07.yetanotheryelp.model.YelpRestaurant

class SharedViewModel : ViewModel() {
    var business by mutableStateOf<YelpRestaurant?>(null)
    private set

    fun addBusiness(newBusiness: YelpRestaurant?) {
        business = newBusiness
    }
}