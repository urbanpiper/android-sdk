package com.urbanpiper.upsdk.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class FCMRegistrationBody(
    @SerializedName("registration_id")
    val fcmRegistrationToken: String,
    @SerializedName("device_id")
    val deviceId: String,
    @SerializedName("channel")
    val channel: String = "app_android"
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}