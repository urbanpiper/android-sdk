package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.AllStoresResponse
import com.urbanpiper.upsdk.model.networkresponse.AppVersionCheckResponse
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import com.urbanpiper.upsdk.model.networkresponse.StoreLocationResponse
import retrofit2.Callback

interface GeneralService {


    /**
     * App version check
     */
    fun appVersionCheck(username: String, version: String, callback: Callback<AppVersionCheckResponse>): CancellableTask

    /**
     * Register the device for FCM
     */
    fun registerDeviceForFCM(fcmRegistrationToken: String, deviceId: String, callback: Callback<Void>): CancellableTask

    fun getNearestStore(latitude: Double, longitude: Double, callback: Callback<StoreLocationResponse>): CancellableTask

    fun getAllStores(callback: Callback<AllStoresResponse>): CancellableTask
}