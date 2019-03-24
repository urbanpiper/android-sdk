package com.urbanpiper.upsdk.model

import com.google.gson.Gson

data class User(
    val bearerToken: String?
    , val token: String?
    , val serverUsername: String?
    , val email: String?
    , val name: String?
    , val phone: String?
    , val jit: String?
    , val exp: String?
    , val iat: String?
    , val balance: String?
    , val points: String?
    , val authKey: String?
    , val userBizId: String?
    , val phoneVerified: Boolean
    , val emailVerified: Boolean
    , val timeSaved: String?
) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
