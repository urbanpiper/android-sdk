package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class FilterAndSortOptionsResponse(
    @SerializedName("filters")
    val filters: List<Filter>,
    @SerializedName("sort_by")
    val sortBy: List<String>
) {
    data class Filter(
        @SerializedName("group")
        val group: String,
        @SerializedName("options")
        val options: List<Option>
    ) {
        data class Option(
            @SerializedName("id")
            val id: Int,
            @SerializedName("title")
            val title: String
        )
    }

    fun toJson(): String {
        return Gson().toJson(this)
    }
}
