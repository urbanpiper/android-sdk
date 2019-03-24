package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.StoreListResponse
import com.urbanpiper.upsdk.model.networkresponse.VersionCheckResponse
import com.urbanpiper.upsdk.model.networkresponse.StoreResponse
import io.reactivex.Observable

interface GeneralService {

    /**
     * returns the latest version of the android app as configured on the server
     *
     * This can be used to force update the application. The response has a field that shows if force update
     * is required. This method should be called when the app is opened and after the user sign's in.
     *
     * @param username - username of the user
     * @param version - version of the application
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun checkAppVersion(username: String, version: String, callback: Callback<VersionCheckResponse>): CancellableTask

    /**
     * returns the latest version of the android app as configured on the server
     *
     * This can be used to force update the application. The response has a field that shows if force update
     * is required. This method should be called when the app is opened and after the user sign's in.
     *
     * @param username - username of the user
     * @param version - version of the application
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun checkAppVersion(username: String, version: String): Observable<VersionCheckResponse>

    /**
     * Register the device for FCM
     *
     * This can be used to force update the application. The response has a field that shows if force update
     * is required. This method should be called when the app is opened and after the user sign's in.
     *
     * @param token - FCM registration token
     * @param deviceId - The unique id of the device
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun registerFCMToken(token: String, deviceId: String, callback: Callback<Void>): CancellableTask

    /**
     * Register the device for FCM
     *
     * This method registers a device to receive FCM messages, This should be called when the app
     * is launched and after the user sign's in to the app
     *
     * @param token - FCM registration token
     * @param deviceId - The unique id of the device
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun registerFCMToken(token: String, deviceId: String): Observable<Void>

    /**
     * Returns the nearest store based on lat/ lng
     *
     * This endpoint helps determine the nearest store from which an order can be delivered.
     * It expects the latitude/longitude information of the location to be delivered to.
     * Along with the store information, this endpoint also returns the biz related information,
     * which can be cached for later use.
     *
     * @param lat - User's latitude
     * @param lng - User's longitude
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getNearestStore(lat: Double, lng: Double, callback: Callback<StoreResponse>): CancellableTask

    /**
     * Returns the nearest store based on lat/ lng
     *
     * This endpoint helps determine the nearest store from which an order can be delivered.
     * It expects the latitude/longitude information of the location to be delivered to.
     * Along with the store information, this endpoint also returns the biz related information,
     * which can be cached for later use.
     *
     * @param lat - User's latitude
     * @param lng - User's longitude
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getNearestStore(lat: Double, lng: Double): Observable<StoreResponse>

    /**
     * Returns all the stores for the business
     *
     * This method returns all the stores configured for a business.
     *
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getAllStores(callback: Callback<StoreListResponse>): CancellableTask

    /**
     * Returns all the stores for the business
     *
     * This method returns all the stores configured for a business.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getAllStores(): Observable<StoreListResponse>
}