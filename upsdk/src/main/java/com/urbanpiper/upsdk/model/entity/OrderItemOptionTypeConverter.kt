package com.urbanpiper.upsdk.model.entity

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.urbanpiper.upsdk.model.networkresponse.OrderItemOption

class OrderItemOptionTypeConverter {

    companion object {

        private val gson = Gson()

        @TypeConverter
        @JvmStatic
        fun fromOrderItemOption(orderItemOptionGroup: ArrayList<OrderItemOption>?): String {
            return gson.toJson(orderItemOptionGroup)
        }

        @TypeConverter
        @JvmStatic
        fun toOrderItemOption(string: String?): ArrayList<OrderItemOption> {
            Log.e("type converter ","string ${string}")
            if (string == null || string.isEmpty() || string == "null"){
                return ArrayList()
            }

            val listType = object : TypeToken<List<OrderItemOption>>() {}.type
            return gson.fromJson(string, listType)
        }
    }

}