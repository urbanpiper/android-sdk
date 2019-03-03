package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.StoreListResponse
import com.urbanpiper.upsdk.model.networkresponse.VersionCheckResponse
import com.urbanpiper.upsdk.model.networkresponse.StoreReponse
import retrofit2.Callback

interface GeneralService {


    /**
     * App version check
     */
    fun checkAppVersion(username: String, version: String, callback: Callback<VersionCheckResponse>): CancellableTask

    /**
     * Register the device for FCM
     *
     * This should return a generic response in the callback
     */
    fun registerFCMToken(token: String, deviceId: String, callback: Callback<Void>): CancellableTask

    /**
     * Returns the nearest store based on lat/ lng
     */
    fun getNearestStore(lat: Double, lng: Double, callback: Callback<StoreReponse>): CancellableTask

    /**
     * Returns all the stores for the biz
     */
    fun getAllStores(callback: Callback<StoreListResponse>): CancellableTask
}