package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class LikedItem(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("item_title")
    var itemTitle: String
)
