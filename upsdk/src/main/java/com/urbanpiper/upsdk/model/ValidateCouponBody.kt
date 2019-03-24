package com.urbanpiper.upsdk.model

import com.google.gson.Gson

class ValidateCouponBody(var order: Order) {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}