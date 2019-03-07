package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class OrderStatusItemOption(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("title")
    var title: String

)

