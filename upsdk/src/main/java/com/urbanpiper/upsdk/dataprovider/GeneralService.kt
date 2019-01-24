package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkResponse.AppVersionCheckResponse
import com.urbanpiper.upsdk.model.networkResponse.BannerResponse
import retrofit2.Callback

interface GeneralService {

    /**
     * Get the banners from the server
     */
    fun getBanners(callback: Callback<BannerResponse>)


    /**
     * App version check
     */
    fun appVersionCheck(username: String, version: String, callback: Callback<AppVersionCheckResponse>)

    /**
     * Register the device for FCM
     */
    fun registerDeviceForFCM(fcmRegistrationToken: String, deviceId: String, callback: Callback<Void>)
}