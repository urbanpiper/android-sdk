package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class UserInfoResponse(
    @SerializedName("address")
    var address: String,
    @SerializedName("anniversary")
    var anniversary: Long = 0,
    @SerializedName("birthday")
    var birthday: Long = 0,
    @SerializedName("current_city")
    var currentCity: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("first_name")
    var firstName: String,
    @SerializedName("gender")
    var gender: String,
    @SerializedName("last_name")
    var lastName: String,
    @SerializedName("phone")
    var phone: String
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}


