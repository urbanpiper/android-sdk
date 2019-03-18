package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class RecommendedItemResponse(
    @SerializedName("meta")
    val meta: ResponseMeta,
    @SerializedName("objects")
    val objects: List<CartItem>
) {

    fun toJson(): String {
        return Gson().toJson(this)
    }
}