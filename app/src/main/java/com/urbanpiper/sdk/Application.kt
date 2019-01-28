package com.urbanpiper.sdk

import android.app.Application
import android.util.Log
import com.urbanpiper.upsdk.dataprovider.CancellableTask
import com.urbanpiper.upsdk.dataprovider.UPClientDefault
import com.urbanpiper.upsdk.model.networkresponse.AppVersionCheckResponse
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import retrofit2.Callback

class MyApp : Application() {

    object Singleton {
        val upClient = UPClientDefault(
            bizId = "76720224",
            apiUsername = "biz_adm_clients_yjXwAgQzHqYM",
            apiKey = "5ee66ab0ec691963ebe2e9485ae0fdfe232d8fa8",
            language = "en"
        )
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Application created ", " UP client init")
    }

    fun getBanners(callback: Callback<BannerResponse>) {
        val task: CancellableTask = MyApp.Singleton.upClient.getBanners(callback)
        task.cancel()
    }

    fun getVersionCheck(username: String, version: String, callback: Callback<AppVersionCheckResponse>) {
        MyApp.Singleton.upClient.appVersionCheck(username, version, callback)
    }


}