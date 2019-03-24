package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class RedeemRewardResponse(
    @SerializedName("expires_in")
    var expireIn: Long = 0,

    @SerializedName("pts_remaining")
    var pointsRemain: Int = 0,

    @SerializedName("redemption_code")
    var redemptionCode: String,

    @SerializedName("status")
    var status: String,

    @SerializedName("message")
    var message: String
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}