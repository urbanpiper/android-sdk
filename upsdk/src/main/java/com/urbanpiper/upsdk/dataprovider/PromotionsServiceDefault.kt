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

    /**
     * The Gallery method returns the list of images that have been uploaded through the configuration portal.
     *
     * These images might be used for different visual purposes, such as:
     * - showing banners in a carousel in the website or app.
     * - showing a promotional popup.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getBanners(): Observable<BannerResponse> {
        return promotionsRetrofitService.getBanners(authToken)
    }

    /**
     * This method returns a list of offers that can be applied to an order
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
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

    /**
     * This method returns a list of offers that can be applied to an order
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getOffers(): Observable<OffersResponse> {
        return promotionsRetrofitService.getOffers(authToken, bizId)
    }

    /**
     * This endpoint returns the list of rewards that are configured in the system.
     * Rewards might be in one of the following states for a user
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
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

    /**
     * This endpoint returns the list of rewards that are configured in the system.
     * Rewards might be in one of the following states for a user
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getRewards(): Observable<RewardsResponse> {
        return promotionsRetrofitService.getRewards(authToken, bizId)
    }

}