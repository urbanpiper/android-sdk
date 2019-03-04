package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.StoreListResponse
import com.urbanpiper.upsdk.model.networkresponse.VersionCheckResponse
import com.urbanpiper.upsdk.model.networkresponse.StoreReponse
import io.reactivex.Observable

interface GeneralService {


    /**
     * App version check
     */
    fun checkAppVersion(username: String, version: String, callback: Callback<VersionCheckResponse>): CancellableTask

    /**
     * App version check
     */
    fun checkAppVersion(username: String, version: String): Observable<VersionCheckResponse>

    /**
     * Register the device for FCM
     *
     * This should return a generic response in the callback
     */
    fun registerFCMToken(token: String, deviceId: String, callback: Callback<Void>): CancellableTask

    /**
     * Register the device for FCM
     *
     * This should return a generic response in the callback
     */
    fun registerFCMToken(token: String, deviceId: String): Observable<Void>

    /**
     * Returns the nearest store based on lat/ lng
     */
    fun getNearestStore(lat: Double, lng: Double, callback: Callback<StoreReponse>): CancellableTask

    /**
     * Returns the nearest store based on lat/ lng
     */
    fun getNearestStore(lat: Double, lng: Double): Observable<StoreReponse>

    /**
     * Returns all the stores for the biz
     */
    fun getAllStores(callback: Callback<StoreListResponse>): CancellableTask

    /**
     * Returns all the stores for the biz
     */
    fun getAllStores(): Observable<StoreListResponse>
}