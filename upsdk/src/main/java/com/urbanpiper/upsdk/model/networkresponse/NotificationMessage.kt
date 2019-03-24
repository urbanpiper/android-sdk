package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class NotificationMessage (

    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("banner_img")
    var bannerImgUrl: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("body")
    var body: String,

    @SerializedName("channel")
    var channel: String,

    @SerializedName("created")
    var created: Long,

    @SerializedName("target")
    var target: String,

    @SerializedName("type")
    var type: String
){
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
