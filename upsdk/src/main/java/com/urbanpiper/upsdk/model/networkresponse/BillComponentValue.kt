package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class BillComponentValue(

    @SerializedName("title")
    var title: String,

    @SerializedName("value")
    var value: Float,

    @SerializedName("rate")
    var rate: Float
)