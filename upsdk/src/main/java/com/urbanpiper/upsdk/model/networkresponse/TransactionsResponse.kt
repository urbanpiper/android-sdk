package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class TransactionsResponse(
    @SerializedName("meta")
    var meta: ResponseMeta,
    @SerializedName("transactions")
    var transactions: List<Transaction>
)
