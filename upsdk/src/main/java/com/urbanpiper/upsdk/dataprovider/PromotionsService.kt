package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import com.urbanpiper.upsdk.model.networkresponse.OffersResponse
import com.urbanpiper.upsdk.model.networkresponse.RewardsResponse
import io.reactivex.Observable

interface PromotionsService {

    /**
     * Retrieves a list of banners
     *
     * @return - Observable - The api response is returned as an RxJava Observable
     */
    fun getBanners(): Observable<BannerResponse>


    /**
     * Retrieves a list of banners
     *
     * @return - Observable - The api response is returned as an RxJava Observable
     */
    fun getBanners(callback: Callback<BannerResponse>): CancellableTask


//    /**
//     * Retrieves a list of banners
//     *
//     * @return - CancellableTask - The response can be cancelled
//     */
//    fun getBanners(callback: Callback<BannerResponse>): CancellableTask

    /**
     * Retrieves a list of offers
     *
     */
    fun getOffers(callback: Callback<OffersResponse>): CancellableTask


    /**
     * Retrieves a list of offers
     *
     */
    fun getOffers(): Observable<OffersResponse>


    /**
     * Retrieves a list of rewards
     *
     */
    fun getRewards(callback: Callback<RewardsResponse>): CancellableTask


    /**
     * Retrieves a list of rewards
     *
     */
    fun getRewards(): Observable<RewardsResponse>

}