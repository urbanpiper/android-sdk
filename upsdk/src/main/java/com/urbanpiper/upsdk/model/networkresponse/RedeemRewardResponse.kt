package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

class RedeemRewardResponse(
    @SerializedName("expires_in")
    var expireIn: Long = 0,

    @SerializedName("pts_remaining")
    var pointsRemain: Int = 0,

    @SerializedName("redemption_code")
    var redemptionCode: String,

    var status: String,

    var message: String
)