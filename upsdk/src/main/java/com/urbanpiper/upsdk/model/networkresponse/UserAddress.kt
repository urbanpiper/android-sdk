package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class UserAddress(
    @SerializedName("id")
    var id: Int,

    @SerializedName("address_1")
    var address1: String,

    @SerializedName("landmark")
    var landmark: String,

    @SerializedName("city")
    var city: String,

    @SerializedName("lat")
    var lat: Double,

    @SerializedName("lng")
    var lng: Double,

    @SerializedName("pin")
    var pin: String,

    @SerializedName("tag")
    var tag: String,

    @SerializedName("pod_id")
    var podId: Int,

    @SerializedName("biz_id")
    var bizId: Int,

    @SerializedName("sub_locality")
    var subLocality: String
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
