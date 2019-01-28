package com.urbanpiper.upsdk.dataprovider

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import com.urbanpiper.upsdk.model.networkresponse.StoreLocationResponse
import com.urbanpiper.upsdk.model.networkresponse.AllStoresResponse
import retrofit2.Call

interface StoreRetrofitService {

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
    ): Call<StoreLocationResponse>


    /**
     * Returns a list of all the stores
     *
     * @param authToken - Authorization token, login not needed
     */
    @GET("/api/v1/stores/")
    fun getAllStores(
        @Header("Authorization") authToken: String
    ): Call<AllStoresResponse>

}

