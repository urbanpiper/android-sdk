package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Like(
    @SerializedName("item")
    var item: LikedItem,

    @SerializedName("liked_on")
    var likedOn: Long = 0
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}