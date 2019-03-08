package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

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
    @SerializedName("enabled_for_ordering")
    val enabledForOrdering: Boolean,
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
    val onSelectMsg: String,
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
    var timeSlots: List<TimeSlot>
)