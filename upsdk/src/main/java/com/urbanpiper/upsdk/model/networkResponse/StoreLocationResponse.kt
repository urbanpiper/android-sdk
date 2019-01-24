package com.urbanpiper.upsdk.model.networkResponse

import com.google.gson.annotations.SerializedName

data class StoreLocationResponse(
    @SerializedName("biz")
    val biz: Biz,
    @SerializedName("store")
    val store: Store
) {
    data class Biz(
        @SerializedName("contact_phone")
        val contactPhone: String,
        @SerializedName("currency")
        val currency: String,
        @SerializedName("delivery_min_offset_time")
        val deliveryMinOffsetTime: Int,
        @SerializedName("feedback_config")
        val feedbackConfig: List<FeedbackConfig>,
        @SerializedName("gst")
        val gst: Any,
        @SerializedName("is_pickup_enabled")
        val isPickupEnabled: Boolean,
        @SerializedName("isd_code")
        val isdCode: String,
        @SerializedName("min_order_total")
        val minOrderTotal: Int,
        @SerializedName("minimum_wallet_credit_threshold")
        val minimumWalletCreditThreshold: Int,
        @SerializedName("msg_nearest_store_closed")
        val msgNearestStoreClosed: String,
        @SerializedName("msg_no_stores_nearby")
        val msgNoStoresNearby: String,
        @SerializedName("msg_store_closed_temporary")
        val msgStoreClosedTemporary: String,
        @SerializedName("order_delivery_radius")
        val orderDeliveryRadius: Int,
        @SerializedName("payment_options")
        val paymentOptions: List<String>,
        @SerializedName("paypal_client_token")
        val paypalClientToken: Any,
        @SerializedName("pg_provider")
        val pgProvider: Any,
        @SerializedName("pickup_min_offset_time")
        val pickupMinOffsetTime: Int,
        @SerializedName("pre_process")
        val preProcess: Boolean,
        @SerializedName("referral_share_lbl")
        val referralShareLbl: String,
        @SerializedName("referral_ui_lbl")
        val referralUiLbl: String,
        @SerializedName("simpl_client_id")
        val simplClientId: Any,
        @SerializedName("supported_languages")
        val supportedLanguages: List<String>,
        @SerializedName("time_slots")
        val timeSlots: List<TimeSlot>,
        @SerializedName("timezone")
        val timezone: String,
        @SerializedName("tin")
        val tin: Any,
        @SerializedName("use_point_of_delivery")
        val usePointOfDelivery: Boolean
    ) {
        data class TimeSlot(
            @SerializedName("day")
            val day: String,
            @SerializedName("end_time")
            val endTime: String,
            @SerializedName("start_time")
            val startTime: String
        )

        data class FeedbackConfig(
            @SerializedName("choices")
            val choices: List<Choice>,
            @SerializedName("type")
            val type: String
        ) {
            data class Choice(
                @SerializedName("id")
                val id: Int,
                @SerializedName("sort_order")
                val sortOrder: Int,
                @SerializedName("text")
                val text: String
            )
        }
    }

    data class Store(
        @SerializedName("address")
        val address: String,
        @SerializedName("biz_location_id")
        val bizLocationId: Int,
        @SerializedName("city")
        val city: String,
        @SerializedName("closing_day")
        val closingDay: Boolean,
        @SerializedName("closing_time")
        val closingTime: String,
        @SerializedName("delivery_charge")
        val deliveryCharge: Int,
        @SerializedName("delivery_min_offset_time")
        val deliveryMinOffsetTime: Int,
        @SerializedName("hide_store_name")
        val hideStoreName: Boolean,
        @SerializedName("lat")
        val lat: Double,
        @SerializedName("lng")
        val lng: Double,
        @SerializedName("min_order_total")
        val minOrderTotal: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("on_close_msg")
        val onCloseMsg: String,
        @SerializedName("on_select_msg")
        val onSelectMsg: Any,
        @SerializedName("opening_time")
        val openingTime: String,
        @SerializedName("packaging_charge")
        val packagingCharge: Int,
        @SerializedName("pg_key")
        val pgKey: String,
        @SerializedName("phone")
        val phone: String,
        @SerializedName("pickup_min_offset_time")
        val pickupMinOffsetTime: Int,
        @SerializedName("sort_order")
        val sortOrder: Int,
        @SerializedName("tax_rate")
        val taxRate: Int,
        @SerializedName("temporarily_closed")
        val temporarilyClosed: Boolean,
        @SerializedName("time_slots")
        val timeSlots: List<TimeSlot>
    ) {
        data class TimeSlot(
            @SerializedName("day")
            val day: String,
            @SerializedName("end_time")
            val endTime: String,
            @SerializedName("start_time")
            val startTime: String
        )
    }
}