package com.urbanpiper.upsdk.dataprovider

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import java.lang.RuntimeException

object SharedPrefManager {

    val spSessionDetails = "sp.user.login.details"
    val spBearerJWTToken = "bearer.jwt.token"
    val spJWTToken = "jwt.token"
    val spAPIUsername = "api.username"
    val spAPIKey = "api.key"
    val spJIT = "jwt.jit"
    val spExp = "jwt.exp"
    val spIat = "jwt.iat"

    private var preferences: SharedPreferences? = null

    fun init(context: Context?) {
        if (context != null) {
            preferences = context.getSharedPreferences(spSessionDetails, Context.MODE_PRIVATE)
        }
    }

    @SuppressLint("ApplySharedPref")
    fun saveBizAuthToken(apiUsername: String, apiKey: String){
        val editor = preferences!!.edit()
        editor.putString(spAPIUsername, apiUsername)
        editor.putString(spAPIKey, apiKey)
        editor.commit()
    }

    /**
     * returns the auth token
     *
     * @param isUserLoggedIn - Boolean
     */
    fun getAuthToken( isUserLoggedIn: Boolean): String {
        return if (isUserLoggedIn) {
            preferences!!.getString(spBearerJWTToken, "")!!
        } else {
            val apiUsername = preferences!!.getString(spAPIUsername, "")
            val apiKey = preferences!!.getString(spAPIKey, "")
            String.format("apikey %s:%s", apiUsername, apiKey)
        }
    }

    /**
     * Checks if the user is logged in or not
     */
    fun isUserLoggedIn(): Boolean {
        val token = preferences!!.getString(spBearerJWTToken, null)
        val jit = preferences!!.getString(spJIT, null)
        val exp = preferences!!.getString(spExp, null)
        val iat = preferences!!.getString(spIat, null)

        return token != null && jit != null && exp != null && iat != null
    }

}