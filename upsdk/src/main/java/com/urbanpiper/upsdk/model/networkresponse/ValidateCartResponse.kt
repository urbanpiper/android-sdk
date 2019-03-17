package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName
import com.urbanpiper.upsdk.model.Order

data class ValidateCartResponse(
    @SerializedName("order")
    var order: Order,

    @SerializedName("notification")
    var notification: String,

    @SerializedName("status")
    var status: String,

    @SerializedName("message")
    var message: String
)
