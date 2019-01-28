package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.FCMRegistrationBody
import com.urbanpiper.upsdk.model.networkresponse.AppVersionCheckResponse
import retrofit2.Call
import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import retrofit2.http.*


/**
 * Defines the general interactions to be made with the server
 */
interface GeneralRetrofitService {

    /**
     * Get the banners from the server
     */
    @GET("/api/v1/galleries/")
    fun getBanners(
        @Header("Authorization") authToken: String,
        @Query("type") type: String = "app_banner"
    ): Call<BannerResponse>


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
    ): Call<AppVersionCheckResponse>

    /**
     * Registers device for fcm
     */
    @POST("/api/v1/device/fcm/")
    fun registerDeviceForFCM(
        @Body fcmRegistrationBody: FCMRegistrationBody,
        @Header("Authorization") authToken: String
    ): Call<Void>
}

