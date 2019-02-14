package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import retrofit2.Callback

interface PromotionsService {


    /**
     * Get the banners from the server
     */
    fun getBanners(callback: Callback<BannerResponse>): CancellableTask



}