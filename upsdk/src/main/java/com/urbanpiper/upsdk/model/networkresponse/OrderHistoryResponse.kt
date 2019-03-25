package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class OrderHistoryResponse(
    @SerializedName("meta")
    var meta: ResponseMeta,

    @SerializedName("orders")
    var orders: List<OrderStatusV2>
){
    fun toJson(): String {
        return Gson().toJson(this)
    }
}


