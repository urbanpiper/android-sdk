package com.urbanpiper.sdk

import android.app.Application
import android.util.Log
import com.urbanpiper.upsdk.dataprovider.*
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import com.urbanpiper.upsdk.model.networkresponse.UserBizInfoResponse
import io.reactivex.Observable

class MyApp : Application() {

    lateinit var upClient: UPClient

    override fun onCreate() {
        super.onCreate()
        Log.d("Application created ", " UP client init")

        upClient = UPClientBuilder()
            .setBizId("76720224")
            .setApiUsername("biz_adm_clients_yjXwAgQzHqYM")
            .setApiKey("5ee66ab0ec691963ebe2e9485ae0fdfe232d8fa8")
            .setLanguage("en")
            .setApplicationContext(applicationContext)
            .setCallback(object : Callback<UserBizInfoResponse> {
                override fun success(response: UserBizInfoResponse) {
                    Log.d("callback response", " $response")
                }

                override fun failure(upClientError: UpClientError) {
                    upClientError.getResponseCode()
                    Log.e("", " Failure response  ${upClientError.getResponseCode()}")
                }
            })
            .build()
    }


    fun getBanners(callback: Callback<BannerResponse>): CancellableTask {
        return upClient.getBanners(callback)
    }

    fun getBanners(): Observable<BannerResponse> {
        return upClient.getBanners()
    }

}