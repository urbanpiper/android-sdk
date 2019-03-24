package com.urbanpiper.upsdk.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class ResendOTPBody(
    @SerializedName("customer_phone")
    val phone: String,
    @SerializedName("customer_name")
    val name: String
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}