package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class UserBizNotificationsResponse(

    @SerializedName("messages")
    var messages: List<NotificationMessage>
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
