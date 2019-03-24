package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class UserAddressSaveResponse(
    @SerializedName("address_id")
    var addressId: Int,
    @SerializedName("status")
    var status: String,
    @SerializedName("message")
    var message: String,
    @SerializedName("result_code")
    var resultCode: String
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
