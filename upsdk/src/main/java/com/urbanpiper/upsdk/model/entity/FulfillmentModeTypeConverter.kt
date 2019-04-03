package com.urbanpiper.upsdk.model.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FulfillmentModeTypeConverter {

    companion object {

        private val gson = Gson()

        @TypeConverter
        @JvmStatic
        fun fromOrderItemOptionGroup(orderItemOptionGroup: Array<String>?): String {
            return gson.toJson(orderItemOptionGroup)
        }

        @TypeConverter
        @JvmStatic
        fun toOrderItemOptionGroup(string: String?): Array<String>? {
            if (string == null || string.isEmpty() || string == "null") {
                return null
            }
            val listType = object : TypeToken<Array<String>>() {}.type
            return gson.fromJson(string, listType)
        }
    }
}