package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName

data class TimeSlot(
    @SerializedName("day")
    val day: String,
    @SerializedName("end_time")
    val endTime: String,
    @SerializedName("start_time")
    val startTime: String
)