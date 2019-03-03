package com.urbanpiper.upsdk.model.networkresponse
import com.google.gson.annotations.SerializedName


data class OffersResponse(
    @SerializedName("coupons")
    val coupons: List<Coupon>,
    @SerializedName("meta")
    val meta: Meta
) {
    data class Coupon(
        @SerializedName("description")
        val description: String,
        @SerializedName("redemption_code")
        val redemptionCode: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("valid_until")
        val validUntil: Long
    )

    data class Meta(
        @SerializedName("limit")
        val limit: Int,
        @SerializedName("next")
        val next: Any,
        @SerializedName("offset")
        val offset: Int,
        @SerializedName("previous")
        val previous: Any,
        @SerializedName("total_count")
        val totalCount: Int
    )
}