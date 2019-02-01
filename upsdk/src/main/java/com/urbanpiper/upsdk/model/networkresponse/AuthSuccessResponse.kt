package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class AuthSuccessResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("token")
    val token: String
)
