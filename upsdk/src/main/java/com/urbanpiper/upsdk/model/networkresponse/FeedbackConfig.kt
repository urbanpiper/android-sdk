package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class FeedbackConfig(
    @SerializedName("choices")
    val choices: List<Choice>,
    @SerializedName("type")
    val type: String
) {
    data class Choice(
        @SerializedName("id")
        val id: Int,
        @SerializedName("sort_order")
        val sortOrder: Int,
        @SerializedName("text")
        val text: String
    )

    fun toJson(): String {
        return Gson().toJson(this)
    }
}