package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import retrofit2.Callback
import retrofit2.Retrofit

class PromotionsServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) : PromotionsService {

    private val promotionsRetrofitService: PromotionsRetrofitService =
        retrofit.create(PromotionsRetrofitService::class.java)

    override fun getBanners(callback: Callback<BannerResponse>): CancellableTask {
        val bannersCall = promotionsRetrofitService.getBanners(authToken)
        bannersCall.clone().enqueue(callback)
        return CancellableTaskWrapper(bannersCall)
    }



}