package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class SocialAuthResponse(
    @SerializedName("authKey")
    var authKey: String,
    @SerializedName("biz")
    var biz: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("message")
    var message: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("timestamp")
    var timestamp: String,
    @SerializedName("username")
    var username: String,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("token")
    var token: String
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}