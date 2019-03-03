package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import com.urbanpiper.upsdk.model.networkresponse.OffersResponse
import com.urbanpiper.upsdk.model.networkresponse.RewardsResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.Callback

class PromotionsServiceDefault(
    private val authToken: String, private val bizId: String, retrofit: Retrofit
) : PromotionsService {

    private val promotionsRetrofitService: PromotionsRetrofitService =
        retrofit.create(PromotionsRetrofitService::class.java)

    override fun getBanners(callback: Callback<BannerResponse>): CancellableTask {
        val bannersCall = promotionsRetrofitService.getBanners(authToken)
        bannersCall.clone().enqueue(callback)
        return CancellableTaskWrapper(bannersCall)
    }

    override fun getBanners(): Observable<BannerResponse> {
        return promotionsRetrofitService.getBannersObservable(authToken)
    }

    override fun getOffers(callback: Callback<OffersResponse>): CancellableTask {
        val offersCall = promotionsRetrofitService.getOffers(authToken, bizId)
        offersCall.clone().enqueue(callback)
        return CancellableTaskWrapper(offersCall)
    }

    override fun getRewards(callback: Callback<RewardsResponse>): CancellableTask {
        val rewardsCall = promotionsRetrofitService.getRewards(authToken, bizId)
        rewardsCall.clone().enqueue(callback)
        return CancellableTaskWrapper(rewardsCall)
    }

}