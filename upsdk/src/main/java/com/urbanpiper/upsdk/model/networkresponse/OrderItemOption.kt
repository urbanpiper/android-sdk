package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class OrderItemOption(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("title")
    var title: String,

    @SerializedName("price")
    var price: Float = 0.toFloat(),

    @SerializedName("description")
    var description: String,

    @SerializedName("sortOrder")
    var sortOrder: Int = 0,

    @SerializedName("imgUrl")
    var imgUrl: String,

    @SerializedName("selected")
    var selected: Boolean = false,

    @SerializedName("nested_option_groups")
    var nestedOptionGroups: List<OrderItemOptionGroup>
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
