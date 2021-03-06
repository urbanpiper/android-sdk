package com.urbanpiper.upsdk.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.urbanpiper.upsdk.model.networkresponse.UserInfoResponse

data class UpdateUserInfoBody(
    @SerializedName("user_data")
    val userData: UserInfoResponse
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}