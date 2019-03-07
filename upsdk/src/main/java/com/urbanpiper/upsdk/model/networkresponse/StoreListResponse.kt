package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class StoreListResponse(
    @SerializedName("stores")
    val stores: List<Store>
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}