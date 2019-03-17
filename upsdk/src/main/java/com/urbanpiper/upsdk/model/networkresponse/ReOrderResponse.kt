package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class ReOrderResponse(
    @SerializedName("delivery_charge")
    var deliveryCharge: Double,

    @SerializedName("items_available")
    var itemsAvailable: List<CartItem> = ArrayList(),

    @SerializedName("items_not_available")
    var itemsNotAvailable: List<CartItem> = ArrayList(),

    @SerializedName("order_item_taxes")
    var orderItemTaxes: Double,

    @SerializedName("order_subtotal")
    var orderSubtotal: Double,

    @SerializedName("order_total")
    var orderTotal: Double,

    @SerializedName("packaging_charge")
    var packagingCharge: Double,

    @SerializedName("biz_location")
    var store: Store
)