package com.urbanpiper.sdk

import android.app.Application
import android.util.Log
import com.urbanpiper.sdk.MyApp.Singleton.upClient
import com.urbanpiper.upsdk.dataprovider.*
import com.urbanpiper.upsdk.model.networkresponse.AuthSuccessResponse
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import com.urbanpiper.upsdk.model.networkresponse.UserBizInfoResponse
import io.reactivex.Observable

class MyApp : Application() {

    object Singleton {

        val upClient: UPClient = UPClientBuilder()
            .setBizId("76720224")
            .setApiUserName("biz_adm_clients_yjXwAgQzHqYM")
            .setApiKey("5ee66ab0ec691963ebe2e9485ae0fdfe232d8fa8")
            .setLanguage("en")
            .setCallback(object : Callback<UserBizInfoResponse>{
                override fun success(response: UserBizInfoResponse) {

                }

                override fun failure(upClientError: UpClientError) {
                    upClientError.getResponseCode()
                }

            })
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("Application created ", " UP client init")

        upClient.changeLanguage("hi")
    }

    fun getBanners(callback: Callback<BannerResponse>): CancellableTask {
        return upClient.getBanners(callback)
    }

    fun getBanners(): Observable<BannerResponse> {
        return upClient.getBanners()
    }

    fun login(phone: String, password: String): Observable<AuthSuccessResponse> {
        return upClient.login(phone, password)
    }

    fun getRegistrationBuilder(): RegistrationBuilder {
        return upClient.getRegistrationBuilder()
    }
}