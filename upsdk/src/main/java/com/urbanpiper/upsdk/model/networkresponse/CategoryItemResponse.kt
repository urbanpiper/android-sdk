package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class CategoryItemResponse(
    @SerializedName("meta")
    val meta: ResponseMeta,
//    @SerializedName("combos")
//    val combos: List<Any>,
    @SerializedName("objects")
    val objects: List<OrderItem>
) {

    fun toJson(): String {
        return Gson().toJson(this)
    }
}