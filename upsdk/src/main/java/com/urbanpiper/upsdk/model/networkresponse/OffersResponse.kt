package com.urbanpiper.upsdk.model.networkresponse
import com.google.gson.annotations.SerializedName

data class OffersResponse(
    @SerializedName("coupons")
    val coupons: List<Coupon>,
    @SerializedName("meta")
    val meta: ResponseMeta
)