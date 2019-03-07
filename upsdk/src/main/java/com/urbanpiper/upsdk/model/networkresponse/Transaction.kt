package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class Transaction(

    @SerializedName("bill_number")
    var billNumber: String,
    @SerializedName("payment_amount")
    var paymentAmount: Float,
    @SerializedName("payment_src")
    var paymentSrc: String,
    @SerializedName("payment_type")
    var paymentType: String,
    @SerializedName("pos_mc_id")
    var posMcId: Long = 0,
    @SerializedName("pos_operator_uname")
    var posOperatorUname: String,
    @SerializedName("transaction_id")
    var transactionId: String,
    @SerializedName("comments")
    var comments: String,
    @SerializedName("created")
    var created: Long = 0,
    @SerializedName("id")
    var id: String,
    @SerializedName("store")
    var store: Store

)
