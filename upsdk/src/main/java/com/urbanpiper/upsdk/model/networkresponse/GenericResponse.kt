package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class GenericResponse(
    @SerializedName("status")
    var status: String,
    @SerializedName("message")
    var message: String,
    @SerializedName("error_message")
    var errorMessage: String,
    @SerializedName("result_code")
    var resultCode: String
)
