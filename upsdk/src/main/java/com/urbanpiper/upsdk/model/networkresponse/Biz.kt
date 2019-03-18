package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/**
 * This class represents the configured information for the business
 *
 * @property contactPhone
 * @property deliveryRadius
 * @property timezone
 * @property currency
 * @property pickupEnabled
 * @property paymentOptions
 * @property walletReloadOpts
 * @property minOrderTotal
 * @property preProcess
 * @property deliveryMinOffsetTime
 * @property pickupMinOffsetTime
 * @property timeSlots
 * @property msgNoStoresNearby
 * @property msgNearestStoreClosed
 * @property msgNearestStoreClosedTemporary
 * @property feedbackConfigs
 * @property usePointOfDelivery
 * @property referralUILbl
 * @property referralShareLbl
 * @property paymentGatewayProvider
 * @property supportedLanguages
 */
data class Biz(
    @SerializedName("contact_phone")
    var contactPhone: String = "",

    @SerializedName("order_delivery_radius")
    var deliveryRadius: Float = 0.toFloat(),

    @SerializedName("timezone")
    var timezone: String? = null,

    @SerializedName("currency")
    var currency: String = "INR",

    @SerializedName("is_pickup_enabled")
    var pickupEnabled: Boolean = false,

    @SerializedName("payment_options")
    var paymentOptions: Array<String>? = arrayOf("prepaid", "cash"),

    @SerializedName("wallet_reload_options")
    var walletReloadOpts: Array<String>? = null,

    @SerializedName("min_order_total")
    var minOrderTotal: Float? = -1.0f,

    @SerializedName("pre_process")
    var preProcess: Boolean = false,

    @SerializedName("delivery_min_offset_time")
    var deliveryMinOffsetTime: Long = 0,

    @SerializedName("pickup_min_offset_time")
    var pickupMinOffsetTime: Long = (3600 * 1000).toLong(),

    @SerializedName("time_slots")
    var timeSlots: List<TimeSlot>? = null,

    @SerializedName("msg_no_stores_nearby")
    var msgNoStoresNearby: String? = null,

    @SerializedName("msg_nearest_store_closed")
    var msgNearestStoreClosed: String? = null,

    @SerializedName("msg_store_closed_temporary")
    var msgNearestStoreClosedTemporary: String? = null,

    @SerializedName("feedback_config")
    var feedbackConfigs: List<FeedbackConfig>? = null,

    @SerializedName("use_point_of_delivery")
    var usePointOfDelivery: Boolean = false,

    @SerializedName("referral_ui_lbl")
    var referralUILbl: String? = null,

    @SerializedName("referral_share_lbl")
    var referralShareLbl: String? = null,

    @SerializedName("pg_provider")
    var paymentGatewayProvider: String? = null,

    @SerializedName("supported_languages")
    var supportedLanguages: Array<String> = arrayOf("en")
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}