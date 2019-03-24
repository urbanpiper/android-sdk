package com.urbanpiper.upsdk.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class VerifyOTPBody(
    @SerializedName("customer_phone")
    val phone: String,
    @SerializedName("pin")
    val pin: String,
    @SerializedName("customer_name")
    val name: String,
    @SerializedName("channel")
    val channel: String
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}