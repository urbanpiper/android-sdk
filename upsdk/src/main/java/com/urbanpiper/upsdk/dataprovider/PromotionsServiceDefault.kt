package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.BannerResponse
import com.urbanpiper.upsdk.model.networkresponse.OffersResponse
import com.urbanpiper.upsdk.model.networkresponse.RewardsResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class PromotionsServiceDefault(
    private val authToken: String, private val bizId: String, retrofit: Retrofit
) : PromotionsService {

    private val promotionsRetrofitService: PromotionsRetrofitService =
        retrofit.create(PromotionsRetrofitService::class.java)

    override fun getBanners(callback: Callback<BannerResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getBanners()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )

        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    override fun getBanners(): Observable<BannerResponse> {
        return promotionsRetrofitService.getBanners(authToken)
    }

    override fun getOffers(callback: Callback<OffersResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getOffers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )

        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    override fun getOffers(): Observable<OffersResponse> {
        return promotionsRetrofitService.getOffers(authToken, bizId)
    }

    override fun getRewards(callback: Callback<RewardsResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getRewards()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )

        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    override fun getRewards(): Observable<RewardsResponse> {
        return promotionsRetrofitService.getRewards(authToken, bizId)
    }

}