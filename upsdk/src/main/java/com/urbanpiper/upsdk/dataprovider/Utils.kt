package com.urbanpiper.upsdk.dataprovider

import android.content.Context

class Utils {



//    /**
//     * returns the auth token
//     *
//     * @param isUserLoggedIn
//     */
//    fun getAuthToken(context: Context, isUserLoggedIn: Boolean): String {
//        return if (isUserLoggedIn) {
//            val sp = context.getSharedPreferences(spSessionDetails, Context.MODE_PRIVATE)
//            sp.getString(spBearerJWTToken, "")!!
//        } else {
//            val sp = context.getSharedPreferences(spSessionDetails, Context.MODE_PRIVATE)
//
//            val apiUsername = sp.getString(spAPIUsername, "")
//            val apiKey = sp.getString(spAPIKey, "")
//            String.format("apikey %s:%s", apiUsername, apiKey)
//        }
//    }

//    /**
//     * tells you if the user is logged in
//     *
//     */
//    fun isUserLoggedIn(context: Context): Boolean {
//        val sp = context.getSharedPreferences(spSessionDetails, Context.MODE_PRIVATE)
//
//        val token = sp.getString(spBearerJWTToken, null)
//        val jit = sp.getString(spJIT, null)
//        val exp = sp.getString(spExp, null)
//        val iat = sp.getString(spIat, null)
//
//        return token != null && jit != null && exp != null && iat != null
//    }


}