package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class OrderCategoriesResponse(
    @SerializedName("biz")
    val biz: Biz,
    @SerializedName("clear_cache")
    val clearCache: Boolean,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("objects")
    val objects: List<Object>
) {
    data class Object(
        @SerializedName("combo_count")
        val comboCount: Int,
        @SerializedName("description")
        val description: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("image")
        val image: String,
        @SerializedName("item_count")
        val itemCount: Int,
        @SerializedName("load_from_web")
        val loadFromWeb: Boolean,
        @SerializedName("name")
        val name: String,
        @SerializedName("slug")
        val slug: String,
        @SerializedName("sort_order")
        val sortOrder: Int,
        @SerializedName("web_url")
        val webUrl: String
    )

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

    data class Meta(
        @SerializedName("limit")
        val limit: Int,
        @SerializedName("next")
        val next: Any,
        @SerializedName("offset")
        val offset: Int,
        @SerializedName("previous")
        val previous: Any,
        @SerializedName("total_count")
        val totalCount: Int
    )

    fun toJson(): String {
        return Gson().toJson(this)
    }
}
