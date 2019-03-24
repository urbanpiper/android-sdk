package com.urbanpiper.upsdk.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class ChangePasswordBody(
    @SerializedName("biz_id")
    var bizId: String,
    @SerializedName("old_password")
    var oldPassword: String,
    @SerializedName("new_password1")
    var newPassword1: String,
    @SerializedName("new_password2")
    var newPassword12: String,
    @SerializedName("phone")
    var phone: String
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}