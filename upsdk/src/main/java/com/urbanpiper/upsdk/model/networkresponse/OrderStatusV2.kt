package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class OrderStatusV2(

    @SerializedName("id")
    var id: Int,

    @SerializedName("address")
    var address: String,

    @SerializedName("user_address_id")
    var userAddressId: Int = -1,

    @SerializedName("biz_location_id")
    var storeId: Int = 0,

    @SerializedName("channel")
    var channel: String,

    @SerializedName("charges")
    var charges: List<BillComponentValue>,

    @SerializedName("created")
    var created: Long,

    @SerializedName("customer_name")
    var customerName: String,

    @SerializedName("delivery_datetime")
    var deliveryDt: Long,

    @SerializedName("coupon")
    var coupon: String,

    @SerializedName("discount")
    var discount: Float,

    @SerializedName("instructions")
    var instructions: String,

    @SerializedName("item_level_total_charges")
    var itemLvlTotalCharges: Float,

    @SerializedName("item_level_total_taxes")
    var itemLvlTotalTaxes: Float,

    @SerializedName("merchant_ref_id")
    var merchantRefId: String,

    @SerializedName("order_level_total_charges")
    var orderLvlTotalCharges: Float,

    @SerializedName("order_level_total_taxes")
    var orderLvlTotalTaxes: Float,

    @SerializedName("order_state")
    var currentState: String,

    @SerializedName("order_subtotal")
    var subTotal: Float,

    @SerializedName("order_total")
    var total: Float,

    @SerializedName("order_type")
    var deliveryType: String,

    @SerializedName("payment_option")
    var paymentOpt: String,

    @SerializedName("phone")
    var phone: String,

    @SerializedName("tax_amt")
    var taxAmt: Float,

    @SerializedName("taxes")
    var taxes: List<BillComponentValue>,

    @SerializedName("total_charges")
    var totalCharges: Float,

    @SerializedName("total_taxes")
    var totalTaxes: Float,

    @SerializedName("item_taxes")
    var itemTaxes: Float,

    @SerializedName("delivery_charge")
    var deliveryCharge: Float,

    @SerializedName("packaging_charge")
    var packagingCharge: Float,

    @SerializedName("items")
    var items: ArrayList<OrderStatusItem> = ArrayList<OrderStatusItem>()

//    @SerializedName("combos")
//    var combos: ArrayList<OrderStatusCombo> = ArrayList<OrderStatusCombo>()
)


