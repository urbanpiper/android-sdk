package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.AppVersionCheckResponse
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import retrofit2.Callback

interface GeneralService {

    /**
     * Get the banners from the server
     */
    fun getBanners(callback: Callback<BannerResponse>): CancellableTask


    /**
     * App version check
     */
    fun appVersionCheck(username: String, version: String, callback: Callback<AppVersionCheckResponse>): CancellableTask

    /**
     * Register the device for FCM
     */
    fun registerDeviceForFCM(fcmRegistrationToken: String, deviceId: String, callback: Callback<Void>): CancellableTask
}