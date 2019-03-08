package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class PreProcessOrderResponse(
    @SerializedName("order")
    var order: Order,

    @SerializedName("notification")
    var notification: String,

    @SerializedName("status")
    var status: String,

    @SerializedName("message")
    var message: String
)
