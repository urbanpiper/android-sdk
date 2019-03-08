package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("biz")
    val biz: Biz,
    @SerializedName("clear_cache")
    val clearCache: Boolean,
    @SerializedName("meta")
    val meta: ResponseMeta,
    @SerializedName("objects")
    val objects: List<OrderCategory>
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
