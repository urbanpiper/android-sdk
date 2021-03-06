package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("sort_order")
    val sortOrder: Int
){
    fun toJson(): String {
        return Gson().toJson(this)
    }
}