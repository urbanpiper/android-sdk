package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.FCMRegistrationBody
import com.urbanpiper.upsdk.model.networkresponse.StoreListResponse
import com.urbanpiper.upsdk.model.networkresponse.VersionCheckResponse
import com.urbanpiper.upsdk.model.networkresponse.StoreResponse
import retrofit2.http.*
import io.reactivex.Observable

/**
 * Defines the general interactions to be made with the server
 */
interface GeneralRetrofitService {

    /**
     * Determines the latest version of the android app
     * as configured on the server.
     */
    @GET("/api/v1/app/android/")
    fun appVersionCheck(
        @Header("Authorization") authToken: String,
        @Query("biz_id") bizId: String,
        @Query("user") username: String,
        @Query("ver") version: String
    ): Observable<VersionCheckResponse>

    /**
     * Registers device for fcm
     */
    @POST("/api/v1/device/fcm/")
    fun registerDeviceForFCM(
        @Body fcmRegistrationBody: FCMRegistrationBody,
        @Header("Authorization") authToken: String
    ): Observable<Void>

    /**
     * Returns the nearest store for the latitude and longitude
     *
     * @param authToken - Authorization token, login not needed
     * @param latitude - User's latitude
     * @param longitude - User's longitude
     */
    @GET("/api/v1/stores/")
    fun getNearestStore(
        @Header("Authorization") authToken: String,
        @Query("lat") latitude: Double,
        @Query("lng") longitude: Double,
        @Query("biz_id") bizId: String
    ): Observable<StoreResponse>


    /**
     * Returns a list of all the stores
     *
     * @param authToken - Authorization token, login not needed
     */
    @GET("/api/v1/stores/")
    fun getAllStores(
        @Header("Authorization") authToken: String
    ): Observable<StoreListResponse>
}

