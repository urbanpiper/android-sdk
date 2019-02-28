package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import io.reactivex.Observable
import retrofit2.Callback

interface PromotionsService {


    /**
     * Get banners from the server
     *
     * @return - CancellableTask - The api request can be cancelled using this task
     */
    fun getBanners(callback: Callback<BannerResponse>): CancellableTask


    /**
     * Get banners from the server
     *
     * @return - Observable - The api response is returned as an RxJava Observable
     */
    fun getBanners(): Observable<BannerResponse>

}