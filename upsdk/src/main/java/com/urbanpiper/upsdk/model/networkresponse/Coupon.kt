package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Coupon(
    @SerializedName("description")
    val description: String,
    @SerializedName("redemption_code")
    val redemptionCode: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("valid_until")
    val validUntil: Long
){
    fun toJson(): String {
        return Gson().toJson(this)
    }
}