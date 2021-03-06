package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class OrderValidateCouponResponse(
    @SerializedName("discount")
    var discount: Discount,

    @SerializedName("items")
    var items: List<CartItem>,

    @SerializedName("item_taxes")
    var itemTaxes: Float = 0.toFloat(),

    @SerializedName("order_subtotal")
    var orderSubtotal: Float = 0.toFloat(),

    @SerializedName("order_total")
    var orderTotal: Float = 0.toFloat(),

    @SerializedName("payable_amount")
    var payableAmt: Float
){
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
