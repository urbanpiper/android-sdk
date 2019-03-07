package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class UserAddress(
    var id: Int,

    @SerializedName("address_1")
    var address1: String,

    @SerializedName("landmark")
    var landmark: String,

    var city: String,

    var lat: Double,

    var lng: Double,

    var pin: String,

    var tag: String,

    @SerializedName("pod_id")
    var podId: Int,

    @SerializedName("biz_id")
    var bizId: Int,

    @SerializedName("sub_locality")
    var subLocality: String
)
