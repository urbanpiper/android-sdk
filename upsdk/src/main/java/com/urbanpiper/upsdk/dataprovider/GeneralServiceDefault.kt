package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.FCMRegistrationBody
import com.urbanpiper.upsdk.model.networkResponse.AppVersionCheckResponse
import com.urbanpiper.upsdk.model.networkResponse.BannerResponse
import retrofit2.Callback
import retrofit2.Retrofit

class GeneralServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) :
    GeneralService {

    private val generalRetrofitService: GeneralRetrofitService =
        retrofit.create(GeneralRetrofitService::class.java)


    override fun getBanners(callback: Callback<BannerResponse>) {
        val bannersCall = generalRetrofitService.getBanners(authToken)
        bannersCall.clone().enqueue(callback)
    }

    override fun appVersionCheck(username: String, version: String, callback: Callback<AppVersionCheckResponse>) {
        val appVersionCheck = generalRetrofitService.appVersionCheck(
            authToken, bizId,  username, version
        )
        appVersionCheck.clone().enqueue(callback)
    }

    override fun registerDeviceForFCM(fcmRegistrationToken: String, deviceId: String, callback: Callback<Void>) {

        val body = FCMRegistrationBody(fcmRegistrationToken, deviceId)

        val regDeviceForFCM = generalRetrofitService.registerDeviceForFCM(body, authToken)

        regDeviceForFCM.clone().enqueue(callback)
    }


}