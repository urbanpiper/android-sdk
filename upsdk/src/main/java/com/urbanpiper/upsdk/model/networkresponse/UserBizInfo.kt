package com.urbanpiper.upsdk.model.networkresponse

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class UserBizInfo(

    @SerializedName("balance")
    var balance: Float,

    @SerializedName("card_numbers")
    var cardNumbers: Array<String>,

    @SerializedName("addresses")
    var addresses: ArrayList<UserAddress>,

    @SerializedName("points")
    var points: Int = 0,

    @SerializedName("num_of_orders")
    var numOfOrders: Int = 0,

    @SerializedName("total_order_value")
    var totalOrderValue: Float = 0.toFloat(),

    @SerializedName("last_order_dt")
    var lastOrderDt: Long = 0,

    @SerializedName("days_since_last_order")
    var daysSinceLastOrder: Int = 0,

    @SerializedName("name")
    var name: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("username")
    var username: String

)
