package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.BuildConfig
import com.urbanpiper.upsdk.model.networkResponse.AllStoresResponse
import com.urbanpiper.upsdk.model.networkResponse.AppVersionCheckResponse
import com.urbanpiper.upsdk.model.networkResponse.BannerResponse
import com.urbanpiper.upsdk.model.networkResponse.StoreLocationResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UPClientDefault(
    private val bizId: String
    , private val apiUsername: String
    , private val apiKey: String
    , private val language: String
) : UPClient {

    private val generalService: GeneralServiceDefault
    private val storeService: StoreServiceDefault

    init {
        val authToken = String.format("apikey %s:%s", apiUsername, apiKey)

        val client: OkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            })
            .addInterceptor { chain ->
                val original = chain.request()
                val request: Request = original.newBuilder()
                    .addHeader("X-App-Version", BuildConfig.VERSION_NAME)
                    .addHeader("X-BID", bizId)
                    .addHeader("X-App-Src", "android")
                    .addHeader("X-Use-Lang", language)
                    .method(original.method(), original.body())
                    .build()
                chain.proceed(request)
            }
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.urbanpiper.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        generalService = GeneralServiceDefault(authToken, bizId, retrofit)
        storeService = StoreServiceDefault(authToken, bizId, retrofit)

    }

    // ----------------------  BASIC DETAILS ------------------------------------

    override fun getBizId(): String {
        return bizId
    }

    override fun getApiUserName(): String {
        return apiUsername
    }

    override fun getAPIKey(): String {
        return apiKey
    }

    override fun getBizLanguage(): String {
        return language
    }

    // -------------------------- GENERAL SERVICE -------------------------------

    override fun getBanners(callback: Callback<BannerResponse>) {
        generalService.getBanners(callback)
    }

    override fun appVersionCheck(username: String, version: String, callback: Callback<AppVersionCheckResponse>) {
        generalService.appVersionCheck(username, version, callback)
    }

    override fun registerDeviceForFCM(fcmRegistrationToken: String, deviceId: String, callback: Callback<Void>) {
        generalService.registerDeviceForFCM(fcmRegistrationToken, deviceId, callback)
    }

    // -------------------------- STORE SERVICE -------------------------------

    override fun getNearestStore(latitude: Double, longitude: Double, callback: Callback<StoreLocationResponse>) {
        storeService.getNearestStore(latitude, longitude, callback)
    }

    override fun getAllStores(callback: Callback<AllStoresResponse>) {
        storeService.getAllStores(callback)
    }




}