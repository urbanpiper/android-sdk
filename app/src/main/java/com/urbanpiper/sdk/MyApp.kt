package com.urbanpiper.sdk

import android.app.Application
import android.util.Log
import com.urbanpiper.sdk.MyApp.Singleton.upClient
import com.urbanpiper.upsdk.dataprovider.CancellableTask
import com.urbanpiper.upsdk.dataprovider.UPClient
import com.urbanpiper.upsdk.dataprovider.UPClientBuilder
import com.urbanpiper.upsdk.model.networkresponse.AppVersionCheckResponse
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import retrofit2.Callback

class MyApp : Application() {

    object Singleton {
        val upClient: UPClient = UPClientBuilder()
            .setBizId("76720224")
            .setApiUserName("biz_adm_clients_yjXwAgQzHqYM")
            .setApiKey("5ee66ab0ec691963ebe2e9485ae0fdfe232d8fa8")
            .setLanguage("en")
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Application created ", " UP client init")

        Log.d("Application created ", " Lang ${upClient.getBizLanguage()}")

        upClient.changeLanguage("hi")

        Log.d("Application created ", " Lang ${upClient.getBizLanguage()}")
    }

    fun getBanners(callback: Callback<BannerResponse>): CancellableTask {
        return upClient.getBanners(callback)
    }

    fun getVersionCheck(username: String, version: String, callback: Callback<AppVersionCheckResponse>): CancellableTask {
        return upClient.appVersionCheck(username, version, callback)
    }

}