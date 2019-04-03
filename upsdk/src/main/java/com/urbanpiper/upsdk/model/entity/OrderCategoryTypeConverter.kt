package com.urbanpiper.upsdk.model.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.urbanpiper.upsdk.model.networkresponse.OrderCategory

class OrderCategoryTypeConverter {

    companion object {
        private val gson = Gson()

        @TypeConverter
        @JvmStatic
        fun fromOrderCategory(category: OrderCategory?): String {
            return gson.toJson(category)
        }

        @TypeConverter
        @JvmStatic
        fun toOrderCategory(string: String?): OrderCategory? {
            if (string == null || string.isEmpty() || string == "null") {
                return null
            }
            val listType = object : TypeToken<OrderCategory>() {}.type
            return gson.fromJson(string, listType)
        }
    }
}