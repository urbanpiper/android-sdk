package com.urbanpiper.upsdk.model

import com.google.gson.Gson

data class JWTAuthLoginBody(
    val username: String,
    val pass: String
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
