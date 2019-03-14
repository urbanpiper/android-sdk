package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class VerifyOTPResponse(
    @SerializedName("card_number")
    val cardNumber: String,
    @SerializedName("customer_email")
    val customerEmail: String,
    @SerializedName("customer_name")
    val customerName: String,
    @SerializedName("customer_phone")
    val customerPhone: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("points")
    val points: Int,
    @SerializedName("prepaid_balance")
    val prepaidBalance: Int,
    @SerializedName("result")
    val result: String,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("total_balance")
    val totalBalance: Int
)