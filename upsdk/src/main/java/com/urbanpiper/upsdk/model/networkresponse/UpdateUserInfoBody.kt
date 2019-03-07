package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class UpdateUserInfoBody(
    @SerializedName("user_data")
    val userData: UserInfoResponse
)