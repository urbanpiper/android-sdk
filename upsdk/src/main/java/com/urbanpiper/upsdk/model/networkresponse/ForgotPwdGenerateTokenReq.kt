package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class ForgotPwdGenerateTokenReq(

    @SerializedName("biz_id")
    var biz_id: String,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("token")
    var token: String = "",
    @SerializedName("new_password1")
    var new_password1: String = "",
    @SerializedName("new_password2")
    var new_password2: String = ""
){
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
