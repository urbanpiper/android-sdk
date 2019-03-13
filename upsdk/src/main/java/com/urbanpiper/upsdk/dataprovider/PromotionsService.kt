package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import com.urbanpiper.upsdk.model.networkresponse.OffersResponse
import com.urbanpiper.upsdk.model.networkresponse.RewardsResponse
import io.reactivex.Observable

interface PromotionsService {

    /**
     * The Gallery method returns the list of images that have been uploaded through the configuration portal.
     *
     * These images might be used for different visual purposes, such as:
     * - showing banners in a carousel in the website or app.
     * - showing a promotional popup.
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getBanners(callback: Callback<BannerResponse>): CancellableTask

    /**
     * The Gallery method returns the list of images that have been uploaded through the configuration portal.
     *
     * These images might be used for different visual purposes, such as:
     * - showing banners in a carousel in the website or app.
     * - showing a promotional popup.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getBanners(): Observable<BannerResponse>

    /**
     * This method returns a list of offers that can be applied to an order
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getOffers(callback: Callback<OffersResponse>): CancellableTask

    /**
     * This method returns a list of offers that can be applied to an order
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getOffers(): Observable<OffersResponse>

    /**
     * This endpoint returns the list of rewards that are configured in the system.
     * Rewards might be in one of the following states for a user
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getRewards(callback: Callback<RewardsResponse>): CancellableTask

    /**
     * This endpoint returns the list of rewards that are configured in the system.
     * Rewards might be in one of the following states for a user
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getRewards(): Observable<RewardsResponse>

}