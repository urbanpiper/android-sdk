package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class Discount (
    @SerializedName("msg")
    var msg: String,

    @SerializedName("success")
    var success: Boolean = false,

    @SerializedName("value")
    var value: Float = 0f
)
