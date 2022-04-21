package com.laraib07.yetanotheryelp.ui.appbar

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laraib07.yetanotheryelp.api.YelpApiService
import com.laraib07.yetanotheryelp.api.YelpApiStatus
import com.laraib07.yetanotheryelp.model.YelpRestaurant
import kotlinx.coroutines.launch

private const val API_KEY = "RyRADNajRFsD8o3HQ98yNm1HJMJs_mE3Z2w5PXCVKKMfMlnOf1pVrDP-hPg0YwrAzB0LaUCDTCWg_hHIC0cfTWdBZXyFmlkUI-GyrB1MAVnkTzv2VfgJ-CymSSUqYnYx"

class SearchViewModel : ViewModel() {
    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    private val _queryState: MutableState<String> = mutableStateOf(value = "")
    val queryState: State<String> = _queryState

    private val _status: MutableState<YelpApiStatus> =
        mutableStateOf(YelpApiStatus.LOADING)
    val status: State<YelpApiStatus> = _status

    var businessList:List<YelpRestaurant?> by mutableStateOf(listOf())

    private val yelpApi = YelpApiService.getInstance()

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    fun updateQueryState(newValue: String) {
        _queryState.value = newValue
    }

    fun getBusiness(query: String) {
        viewModelScope.launch {
            _status.value = YelpApiStatus.LOADING
            try {
                val list = yelpApi.getRestaurants(
                    "Bearer $API_KEY",
                    query,
                    "New York"
                )
                businessList = list.restaurants
                _status.value = YelpApiStatus.DONE
            } catch (e: Exception) {
                _status.value = YelpApiStatus.ERROR
                businessList = ArrayList()
            }
        }
    }
}