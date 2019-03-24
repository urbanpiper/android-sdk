package com.urbanpiper.upsdk.dataprovider

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log

object SharedPrefManager {

    private var preferences: SharedPreferences? = null

    fun init(context: Context?) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context)
        Log.d("content provider init ", " Shared prefs successful")
    }


    fun getTest(): String {
        return if (preferences != null) {
            "I am init"
        } else {
            "I am not init"
        }
    }


}