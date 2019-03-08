package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DeliverableAddress(
    @SerializedName("address_1")
    private var address1: String,
    @SerializedName("landmark")
    private var landmark: String,
    @SerializedName("city")
    private var city: String,
    @SerializedName("deliverable")
    private var deliverable: Boolean,
    @SerializedName("id")
    private var id: Int,
    @SerializedName("lat")
    private var lat: Double,
    @SerializedName("lng")
    private var lng: Double,
    @SerializedName("name")
    private var name: String,
    @SerializedName("phone")
    private var phone: String,
    @SerializedName("pin")
    private var pin: String,
    @SerializedName("pod_id")
    private var podId: Int,
    @SerializedName("sub_locality")
    private var subLocality: String,
    @SerializedName("tag")
    private var tag: String
){
    fun toJson(): String {
        return Gson().toJson(this)
    }
}