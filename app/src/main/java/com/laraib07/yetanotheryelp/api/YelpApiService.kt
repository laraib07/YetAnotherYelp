package com.laraib07.yetanotheryelp.api

import com.laraib07.yetanotheryelp.model.YelpData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


private const val BASE_URL = "https://api.yelp.com/v3/"

interface YelpApiService {

    @GET("businesses/search")
    suspend fun getRestaurants(
        @Header("Authorization") authHeader: String,
        @Query("term") searchTerm: String,
        @Query("location") location: String
    ): YelpData

    companion object {
        var apiService: YelpApiService? = null

        fun getInstance() : YelpApiService {
            if(apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(YelpApiService::class.java)
            }
            return apiService!!
        }
    }
}