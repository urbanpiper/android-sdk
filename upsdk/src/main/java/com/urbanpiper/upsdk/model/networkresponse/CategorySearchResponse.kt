package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class CategorySearchResponse(
//    @SerializedName("combos")
//    val combos: List<Any>,

    @SerializedName("items")
    val items: List<CartItem>,

    @SerializedName("meta")
    val meta: ResponseMeta

) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}