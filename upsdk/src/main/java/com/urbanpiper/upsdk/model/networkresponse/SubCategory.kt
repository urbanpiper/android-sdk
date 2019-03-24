package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class SubCategory(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("item_count")
    var itemCount: Int = 0,

    @SerializedName("combo_count")
    var comboCount: Int = 0,

    @SerializedName("name")
    var name: String,

    @SerializedName("sort_order")
    var sortOrder: Int = 0,

    @SerializedName("description")
    var description: String,

    @SerializedName("image")
    var imageUrl: String,

    @SerializedName("load_from_web")
    var loadFromWeb: Boolean = false,

    @SerializedName("web_url")
    var webUrl: String
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
