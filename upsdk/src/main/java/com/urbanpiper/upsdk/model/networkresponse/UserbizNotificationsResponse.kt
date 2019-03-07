package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class UserbizNotificationsResponse (

    @SerializedName("messages")
    var messages: List<NotificationMessage>
)
