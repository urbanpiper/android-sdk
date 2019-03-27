package com.urbanpiper.upsdk.dataprovider

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.text.format.Time
import com.auth0.android.jwt.JWT
import com.urbanpiper.upsdk.model.User

object SharedPrefManager {

    private const val SP_SESSION_DETAILS = "sp.user.login.details"

    private const val SP_API_USERNAME = "api.username"
    private const val SP_API_KEY = "api.key"

    private const val SP_BEARER_JWT_TOKEN = "jwt.bearer.token"
    private const val SP_JWT_TOKEN = "jwt.token"
    private const val SP_SERVER_USERNAME = "jwt.server.username"
    private const val SP_EMAIL = "jwt.email"
    private const val SP_NAME = "jwt.name"
    private const val SP_PHONE = "jwt.phone"
    private const val SP_JIT = "jwt.jit"
    private const val SP_EXP = "jwt.exp"
    private const val SP_IAT = "jwt.iat"
    private const val SP_BALANCE = "jwt.balance"
    private const val SP_PTS_BALANCE = "jwt.points.balance"
    private const val SP_AUTH_KEY = "jwt.auth.key"
    private const val SP_USER_BIZ_ID = "jwt.user.biz.id"
    private const val SP_PHONE_VERIFIED = "jwt.phone.verified"
    private const val SP_EMAIL_VERIFIED = "jwt.email.verified"
    private const val SP_TIME_SAVED = "jwt.details.saved.at"

    private lateinit var preferences: SharedPreferences

    fun init(context: Context?) {
        if (context != null) {
            preferences = context.getSharedPreferences(SP_SESSION_DETAILS, Context.MODE_PRIVATE)
        }
    }

    @SuppressLint("ApplySharedPref")
    fun saveBizAuthToken(apiUsername: String, apiKey: String) {
        val editor = preferences.edit()
        editor.putString(SP_API_USERNAME, apiUsername)
        editor.putString(SP_API_KEY, apiKey)
        editor.commit()
    }

    /**
     * returns the auth token
     *
     * @param isUserLoggedIn - Boolean
     */
    fun getAuthToken(isUserLoggedIn: Boolean): String {
        return if (isUserLoggedIn) {
            preferences.getString(SP_BEARER_JWT_TOKEN, "")!!
        } else {
            val apiUsername = preferences.getString(SP_API_USERNAME, "")
            val apiKey = preferences.getString(SP_API_KEY, "")
            String.format("apikey %s:%s", apiUsername, apiKey)
        }
    }

    /**
     * Checks if the user is logged in or not
     */
    fun isUserLoggedIn(): Boolean {
        val token = preferences.getString(SP_BEARER_JWT_TOKEN, null)
        val jit = preferences.getString(SP_JIT, null)
        val exp = preferences.getString(SP_EXP, null)
        val iat = preferences.getString(SP_IAT, null)

        return token != null && jit != null && exp != null && iat != null
    }

    @SuppressLint("ApplySharedPref")
    fun saveToken(token: String) {

        val JWTToken = "Bearer $token"

        val jwt = JWT(token)

        val serverUsername = jwt.getClaim("username").asString()
        val firstName = jwt.getClaim("first_name").asString()
        val lastName = jwt.getClaim("last_name").asString()
        val email = jwt.getClaim("email").asString()
        val userBizId = jwt.getClaim("userbiz_id").asString()
        val phone = jwt.getClaim("phone").asString()
        val balance = jwt.getClaim("balance").asString()
        val points = jwt.getClaim("points").asString()
        val authToken = jwt.getClaim("t_key").asString()

        val phoneVerified = jwt.getClaim("phone_verified").asBoolean()!!
        val emailVerified = jwt.getClaim("email_verified").asBoolean()!!

        // The unique server side id for the token
        val jit = jwt.getClaim("jit").asString()

        // the unix time (UTC) at which the token will expire
        val exp = jwt.getClaim("exp").asString()

        // the unix time (UTC) at which the token was issued.
        val iat = jwt.getClaim("iat").asString()

        val name = "$firstName $lastName"

        val today = Time(Time.getCurrentTimezone())
        val rightNow = today.setToNow().toString()

        val editor = preferences.edit()

        editor.putString(SP_BEARER_JWT_TOKEN, JWTToken)
        editor.putString(SP_JWT_TOKEN, token)
        editor.putString(SP_SERVER_USERNAME, serverUsername)
        editor.putString(SP_EMAIL, email)
        editor.putString(SP_NAME, name)
        editor.putString(SP_PHONE, phone)
        editor.putString(SP_JIT, jit)
        editor.putString(SP_EXP, exp)
        editor.putString(SP_IAT, iat)
        editor.putString(SP_BALANCE, balance)
        editor.putString(SP_PTS_BALANCE, points)
        editor.putString(SP_AUTH_KEY, authToken)
        editor.putString(SP_USER_BIZ_ID, userBizId)
        editor.putBoolean(SP_PHONE_VERIFIED, phoneVerified)
        editor.putBoolean(SP_EMAIL_VERIFIED, emailVerified)
        editor.putString(SP_TIME_SAVED, rightNow)

        editor.commit()
    }

    fun getUser(): User {
        val user = User(
            preferences.getString(SP_BEARER_JWT_TOKEN, ""),
            preferences.getString(SP_JWT_TOKEN, ""),
            preferences.getString(SP_SERVER_USERNAME, ""),
            preferences.getString(SP_EMAIL, ""),
            preferences.getString(SP_NAME, ""),
            preferences.getString(SP_PHONE, ""),
            preferences.getString(SP_JIT, ""),
            preferences.getString(SP_EXP, ""),
            preferences.getString(SP_IAT, ""),
            preferences.getString(SP_BALANCE, ""),
            preferences.getString(SP_PTS_BALANCE, ""),
            preferences.getString(SP_AUTH_KEY, ""),
            preferences.getString(SP_USER_BIZ_ID, ""),
            preferences.getBoolean(SP_PHONE_VERIFIED, true),
            preferences.getBoolean(SP_EMAIL_VERIFIED, true),
            preferences.getString(SP_TIME_SAVED, "")
        )
        return user
    }

}