package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class OrderSaveResponse(
    @SerializedName("status")
    var status: String,

    @SerializedName("message")
    var message: String,

    @SerializedName("error_details")
    var errorDetails: Map<String, String>,

    @SerializedName("order_id")
    var orderId: String
)
