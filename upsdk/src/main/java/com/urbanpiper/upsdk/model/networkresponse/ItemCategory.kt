package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class ItemCategory(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
){
    fun toJson(): String {
        return Gson().toJson(this)
    }
}