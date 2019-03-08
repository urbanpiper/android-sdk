package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class StoreReponse(
    @SerializedName("biz")
    val biz: Biz,
    @SerializedName("store")
    val store: Store
) {

    fun toJson(): String {
        return Gson().toJson(this)
    }
}