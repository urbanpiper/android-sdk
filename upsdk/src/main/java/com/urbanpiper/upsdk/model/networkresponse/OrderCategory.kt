package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class OrderCategory(

    @SerializedName("combo_count")
    val comboCount: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("item_count")
    val itemCount: Int,
    @SerializedName("load_from_web")
    val loadFromWeb: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("sort_order")
    val sortOrder: Int,
    @SerializedName("web_url")
    val webUrl: String
){
    fun toJson(): String {
        return Gson().toJson(this)
    }
}