package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import com.urbanpiper.upsdk.model.networkresponse.OffersResponse
import com.urbanpiper.upsdk.model.networkresponse.RewardsResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PromotionsRetrofitService {

    @GET("/api/v1/galleries/")
    fun getBanners(
        @Header("Authorization") authToken: String,
        @Query("type") type: String = "app_banner"
    ): Observable<BannerResponse>


    @GET("/api/v1/coupons/")
    fun getOffers(
        @Header("Authorization") authToken: String,
        @Query("biz_id") bizId: String
    ): Observable<OffersResponse>


    @GET("/api/v2/rewards/")
    fun getRewards(
        @Header("Authorization") apiAuth: String,
        @Query("biz_id") bizId: String
    ): Observable<RewardsResponse>

}