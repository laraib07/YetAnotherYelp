package com.laraib07.yetanotheryelp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.laraib07.yetanotheryelp.model.YelpBusiness

class SharedViewModel : ViewModel() {
    var business by mutableStateOf<YelpBusiness?>(null)
    private set

    fun addBusiness(newBusiness: YelpBusiness?) {
        business = newBusiness
    }
}