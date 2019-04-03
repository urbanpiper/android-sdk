package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

/**
 * This class represents the configured information for the business
 *
 * @property contactPhone - Phone number of the business
 * @property deliveryRadius - Delivery radius of the business
 * @property timezone - shows the time zone of the business
 * @property currency - currency of the business
 * @property pickupEnabled - boolean to show if pickup is enabled for the business
 * @property paymentOptions - payment options of available
 * @property walletReloadOpts - wallet reload options for the business
 * @property minOrderTotal - minimum order total
 * @property preProcess - pre process
 * @property deliveryMinOffsetTime - minimum time for the order to be delivered
 * @property pickupMinOffsetTime - minimum time before the order can be picked up
 * @property timeSlots - Time slots for delivery
 * @property msgNoStoresNearby - Message to be shown when no stores are nearby
 * @property msgNearestStoreClosed - message to be shown when nearest store is closed
 * @property msgNearestStoreClosedTemporary - message to be shown when nearest store is closed temp
 * @property feedbackConfigs - The feedback options to be shown to the user, other than stars
 * @property usePointOfDelivery - Flag to use point of delivery mode
 * @property referralUILbl - The text to be shown for referral label
 * @property referralShareLbl - The text to be shown for the referral label
 * @property paymentGatewayProvider - the payment gateway provider
 * @property supportedLanguages - the languages supported by the business
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