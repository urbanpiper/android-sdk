package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

import java.io.Serializable

data class ResponseMeta(
    @SerializedName("limit")
    var limit: Int = 0,
    @SerializedName("next")
    var next: String? = null,
    @SerializedName("offset")
    var offset: Int = 0,
    @SerializedName("previous")
    var previous: String? = null,
    @SerializedName("total_count")
    var totalCount: Int = 0
)




