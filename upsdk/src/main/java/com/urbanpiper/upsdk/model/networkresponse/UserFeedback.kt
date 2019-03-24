package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class UserFeedback(
    @SerializedName("username")
    var username: String,

    @SerializedName("rating")
    var rating: Int = 0,

    @SerializedName("type")
    var type: Type,

    @SerializedName("biz_id")
    var bizId: Int = 0,

    @SerializedName("name")
    var name: String,

    @SerializedName("comments")
    var comments: String,

    @SerializedName("type_id")
    var typeId: String,

    @SerializedName("choice_text")
    var choiceText: String
) {
    enum class Type {
        ORDERING, DEFAULT
    }

    fun toJson(): String {
        return Gson().toJson(this)
    }
}
