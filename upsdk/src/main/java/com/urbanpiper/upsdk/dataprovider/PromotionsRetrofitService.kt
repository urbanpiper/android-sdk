package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PromotionsRetrofitService {

    /**
     * Get the banners from the server
     */
    @GET("/api/v1/galleries/")
    fun getBanners(
        @Header("Authorization") authToken: String,
        @Query("type") type: String = "app_banner"
    ): Call<BannerResponse>


}