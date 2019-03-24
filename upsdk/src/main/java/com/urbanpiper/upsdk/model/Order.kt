package com.urbanpiper.upsdk.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.urbanpiper.upsdk.model.networkresponse.Discount
import com.urbanpiper.upsdk.model.networkresponse.CartItem
import com.urbanpiper.upsdk.model.networkresponse.Store
import java.util.*

data class Order(
    @SerializedName("id")
    var id: String,

    @SerializedName("biz_location_id")
    var storeId: Int = 0,

    @SerializedName("delivery_charge")
    var deliveryCharge: Float = 0f,

    @SerializedName("packaging_charge")
    var packagingCharge: Float = 0f,

    @SerializedName("tax_rate")
    var taxRate: Float = 0f,

    @SerializedName("order_subtotal")
    var subtotalAmt: Float = 0f,

    @SerializedName("order_total")
    var totalAmt: Float = 0f,

    @SerializedName("payable_amount")
    var payableAmt: Float = 0f,

    @SerializedName("delivery_datetime")
    var deliveryTime: Long = 0,

    @SerializedName("order_type")
    var deliveryType: String,

    @SerializedName("payment_option")
    var paymentOption: String,

    @SerializedName("coupon")
    var coupon: String,

    @SerializedName("payment_server_trx_id")
    var trxId: String,

    @SerializedName("address_lat")
    var lat: Double = 0.0,

    @SerializedName("address_lng")
    var lng: Double = 0.0,

    @SerializedName("item_taxes")
    var totalItemTaxes: Float = 0f,

    @SerializedName("discount_applied")
    var discountApplied: Float = 0f,

    @SerializedName("channel")
    var channel: String = "app_android",

    @SerializedName("discount")
    var discount: Float = 0f,

    @SerializedName("discount")
    var discountObj: Discount? = null,

    @SerializedName("store")
    @Transient
    var store: Store,

    @SerializedName("items")
    var items: List<CartItem> = ArrayList(),

    @SerializedName("cartItems")
    var cartItems: List<CartItem> = ArrayList(),

    @SerializedName("address")
    var address: String? = null,

    @SerializedName("apply_wallet_credit")
    var applyWalletCredit: Boolean? = false,

    @SerializedName("wallet_credit_applicable")
    var walletCreditsApplicable: Boolean = false,

    @SerializedName("wallet_credit_applied")
    var walletCreditApplied: Float? = 0.0f,

    @SerializedName("total_taxes")
    var totalTaxes: Float? = 0f,

    @SerializedName("total_charges")
    var totalCharges: Float? = 0f,

    @SerializedName("address_id")
    var addressId: Int = -1,

    @SerializedName("time_slot_start")
    var timeSlotStart: String,

    @SerializedName("time_slot_end")
    var timeSlotEnd: String,

    @SerializedName("state")
    var state: String,

    @SerializedName("phone")
    var phone: String,

    @SerializedName("instructions")
    var instructions: String,

    @SerializedName("created")
    var created: Date,

    @SerializedName("payment_modes")
    var paymentModes: Array<String>
) {

    fun toJson(): String {
        return Gson().toJson(this)
    }

    val PAYMENT_OPT_PG = "payment_gateway"
    val PAYMENT_OPT_PAYTM = "paytm"
    val PAYMENT_OPT_ONLINE_RZP = "razor_pay"
    val PAYMENT_OPT_ONLINE_INSTAMOJO = "instamojo"
    val PAYMENT_OPT_PREPAID = "prepaid"
    val PAYMENT_OPT_CASH = "cash"
    val PAYMENT_OPT_SIMPL = "simpl"
    val PAYMENT_OPT_PAYPAL = "paypal"
    val PAYMENT_OPT_SELECT = "select"
    val ORDER_STATE_AWAITING_PAYMENT = "awaiting_payment"
    val DELIVERY_TYPE_PICKUP = "Pickup"
    val DELIVERY_TYPE_DELIVERY = "Delivery"

}
