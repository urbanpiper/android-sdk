package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


data class BannerResponse(

    @SerializedName("images")
    val images: List<Image>,

    @SerializedName("meta")
    val meta: ResponseMeta
) {
    data class Image(
        @SerializedName("created")
        val created: Long,
        @SerializedName("id")
        val id: Int,
        @SerializedName("image")
        val image: String,
        @SerializedName("img_type")
        val imgType: String,
        @SerializedName("markups")
        val markups: String
    )

    fun toJson(): String {
        return Gson().toJson(this)
    }
}
