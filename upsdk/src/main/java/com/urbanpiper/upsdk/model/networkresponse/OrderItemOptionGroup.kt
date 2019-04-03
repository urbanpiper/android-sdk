package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class OrderItemOptionGroup(
    @SerializedName("id")
    var id: Int? = 0,

    @SerializedName("title")
    var title: String?,

    @SerializedName("description")
    var description: String?,

    @SerializedName("max_selectable")
    var maxSelectable: Int? = 0,

    @SerializedName("min_selectable")
    var minSelectable: Int? = 0,

    @SerializedName("sort_order")
    var sortOrder: Int? = 0,

    @SerializedName("is_default")
    var isDefault: Boolean? = false,

    @SerializedName("options")
    var options: ArrayList<OrderItemOption>? = ArrayList(),

    @SerializedName("isNested")
    var isNested: Boolean? = false,

    @SerializedName("parentOptionGroupId")
    var parentOptionGroupId: Int? = -1
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}