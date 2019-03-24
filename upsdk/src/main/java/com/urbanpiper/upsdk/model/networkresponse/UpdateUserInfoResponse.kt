package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class UpdateUserInfoResponse(
    @SerializedName("msg")
    var msg: String,
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("status")
    var status: String
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}