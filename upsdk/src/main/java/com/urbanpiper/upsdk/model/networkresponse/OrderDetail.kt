package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class OrderDetail(

    @SerializedName("details")
    var summary: OrderStatusV2,
    @SerializedName("items")
    var items: List<OrderStatusItem> = ArrayList(),
    @SerializedName("next_states")
    var nextStates: Array<String>,
    @SerializedName("next_state")
    var nextState: String,
    @SerializedName("payment")
    var payment: List<Payment>,
    @SerializedName("store")
    var store: Store

) {

    data class Payment(
        @SerializedName("amount")
        var amount: Float,
        @SerializedName("option")
        var option: String,
        @SerializedName("srvr_trx_id")
        var serverTxnId: String
    )

    fun toJson(): String {
        return Gson().toJson(this)
    }
}
