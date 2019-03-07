package com.urbanpiper.upsdk.model.networkresponse

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
        var srvrTxnId: String
    )

    data class Store(
        @SerializedName("id")
        var id: Int,
        @SerializedName("address")
        var address: String,
        @SerializedName("latitude")
        var latitude: Double,
        @SerializedName("longitude")
        var longitude: Double,
        @SerializedName("merchant_ref_id")
        var merchantRefId: String,
        @SerializedName("name")
        var name: String
    )
}
