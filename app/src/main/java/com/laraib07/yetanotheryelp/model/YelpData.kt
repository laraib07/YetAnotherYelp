package com.laraib07.yetanotheryelp.model

import com.google.gson.annotations.SerializedName

data class YelpData(
    @SerializedName("total") val total: Int?,
    @SerializedName("businesses") val businesses : List<YelpBusiness?>
)

data class YelpBusiness(
    val name: String?,
    val rating: Double?,
    val price: String?,
    val categories: List<YelpCategories?>,
    val location: YelpLocation?,
    @SerializedName("image_url") val imageUrl: String?,
    @SerializedName("review_count") val numReviews: Int?
)

data class YelpCategories(
    val title: String?
)

data class YelpLocation(
    @SerializedName("address1") val address: String?
)