package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class OrderDetailResponse(
    @SerializedName("customer")
    var customer: OrderCustomerInfo,
    @SerializedName("order")
    var order: OrderDetail
)
