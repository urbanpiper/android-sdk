package com.urbanpiper.upsdk.model

import com.google.gson.Gson

data class JWTRefreshTokenBody(val token: String){
    fun toJson(): String {
        return Gson().toJson(this)
    }
}