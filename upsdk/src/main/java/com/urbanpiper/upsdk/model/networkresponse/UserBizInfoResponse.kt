package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class UserBizInfoResponse(

    @SerializedName("meta")
    val meta: ResponseMeta,

    @SerializedName("objects")
    val userBizInfoList: ArrayList<UserBizInfo>
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}