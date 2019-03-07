package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class OrderStatusItem(
    @SerializedName("id")
    var id: Int = 0,

    @SerializedName("image_url")
    var imgUrl: String,

    @SerializedName("image_landscape")
    var landscapeImgUrl: String,

    @SerializedName("title")
    var title: String,

    @SerializedName("quantity")
    var quantity: Int = 0,

    @SerializedName("price")
    var price: Float = 0.toFloat(),

    @SerializedName("options_to_add")
    var options: List<OrderStatusItemOption>,

    @SerializedName("options_to_remove")
    var optionsToRemove: List<OrderStatusItemOption>,

    @SerializedName("total")
    var total: Float = 0.toFloat(),

    @SerializedName("taxes")
    var taxes: List<BillComponentValue>,

    @SerializedName("charges")
    var charges: List<BillComponentValue>
)