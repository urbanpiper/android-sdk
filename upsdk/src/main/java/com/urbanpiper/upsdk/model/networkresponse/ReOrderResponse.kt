package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class ReOrderResponse(
    @SerializedName("delivery_charge")
    var deliveryCharge: Double? = null,

    @SerializedName("items_available")
    var itemsAvailable: List<OrderItem> = ArrayList<OrderItem>(),

    @SerializedName("items_not_available")
    var itemsNotAvailable: List<OrderItem> = ArrayList<OrderItem>(),

    @SerializedName("order_item_taxes")
    var orderItemTaxes: Double? = null,

    @SerializedName("order_subtotal")
    var orderSubtotal: Double? = null,

    @SerializedName("order_total")
    var orderTotal: Double? = null,

    @SerializedName("packaging_charge")
    var packagingCharge: Double? = null,

    @SerializedName("biz_location")
    var store: Store? = null
)