package com.urbanpiper.upsdk.model.networkResponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName


data class BannerResponse(
    @SerializedName("images")
    val images: List<Image>,
    @SerializedName("meta")
    val meta: Meta
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

    data class Meta(
        @SerializedName("limit")
        val limit: Int,
        @SerializedName("offset")
        val offset: Int,
        @SerializedName("total_count")
        val totalCount: Int
    )

    fun toJson(): String {
        return Gson().toJson(this)
    }
}
