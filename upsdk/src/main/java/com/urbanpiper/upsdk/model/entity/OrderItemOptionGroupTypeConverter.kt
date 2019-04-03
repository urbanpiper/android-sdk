package com.urbanpiper.upsdk.model.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.urbanpiper.upsdk.model.networkresponse.OrderItemOptionGroup
import kotlin.collections.ArrayList

class OrderItemOptionGroupTypeConverter {

    companion object {

        private val gson = Gson()

        @TypeConverter
        @JvmStatic
        fun fromOrderItemOptionGroup(orderItemOptionGroup: ArrayList<OrderItemOptionGroup>?): String {
            return gson.toJson(orderItemOptionGroup)
        }

        @TypeConverter
        @JvmStatic
        fun toOrderItemOptionGroup(string: String?): ArrayList<OrderItemOptionGroup> {
            if (string == null || string.isEmpty() || string == "null") {
                return ArrayList()
            }

            val listType = object : TypeToken<List<OrderItemOptionGroup>>() {}.type
            return gson.fromJson(string, listType)
        }
    }
}