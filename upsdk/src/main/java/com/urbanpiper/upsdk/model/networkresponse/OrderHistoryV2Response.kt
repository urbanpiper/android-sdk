package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class OrderHistoryV2Response(
    @SerializedName("meta")
    var meta: ResponseMeta,

    @SerializedName("orders")
    var orders: List<OrderStatusV2>
)


