package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class PaymentCallbackResponse(
    @SerializedName("txn_id")
    var txnId: String,

    @SerializedName("status")
    private val state: Int = 0,

    @SerializedName("pid")
    var pid: String
){
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
