package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class OrderCustomerInfo(
    @SerializedName("address")
    var address: DeliveryAddress,
    @SerializedName("email")
    var email: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("phone")
    var phone: String
) {

    data class DeliveryAddress(
        @SerializedName("line_1")
        var line1: String,
        @SerializedName("line_2")
        var line2: String,
        @SerializedName("sub_locality")
        var subLocality: String,
        @SerializedName("city")
        var city: String,
        @SerializedName("pin")
        var pin: String,
        @SerializedName("latitude")
        var latitude: Double,
        @SerializedName("longitude")
        var longitude: Double
    )

    fun toJson(): String {
        return Gson().toJson(this)
    }
}
