package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.FCMRegistrationBody
import com.urbanpiper.upsdk.model.networkresponse.StoreListResponse
import com.urbanpiper.upsdk.model.networkresponse.VersionCheckResponse
import com.urbanpiper.upsdk.model.networkresponse.StoreReponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class GeneralServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) :
    GeneralService {

    private val generalRetrofitService: GeneralRetrofitService =
        retrofit.create(GeneralRetrofitService::class.java)

    /**
     * App version check
     */
    override fun checkAppVersion(
        username: String,
        version: String,
        callback: Callback<VersionCheckResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            checkAppVersion(username, version)
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
     * App version check
     */
    override fun checkAppVersion(username: String, version: String): Observable<VersionCheckResponse> {
        return generalRetrofitService.appVersionCheck(authToken, bizId, username, version)
    }

    /**
     * Register the device for FCM
     *
     * This should return a generic response in the callback
     */
    override fun registerFCMToken(token: String, deviceId: String, callback: Callback<Void>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            registerFCMToken(token, deviceId)
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
     * Register the device for FCM
     *
     * This should return a generic response in the callback
     */
    override fun registerFCMToken(token: String, deviceId: String): Observable<Void> {
        val fcmRegistrationBody = FCMRegistrationBody(token, deviceId)
        return generalRetrofitService.registerDeviceForFCM(fcmRegistrationBody, authToken)
    }

    /**
     * Returns the nearest store based on lat/ lng
     */
    override fun getNearestStore(lat: Double, lng: Double, callback: Callback<StoreReponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getNearestStore(lat, lng)
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
     * Returns the nearest store based on lat/ lng
     */
    override fun getNearestStore(lat: Double, lng: Double): Observable<StoreReponse> {
        return generalRetrofitService.getNearestStore(authToken, lat, lng, bizId)
    }

    /**
     * Returns all the stores for the biz
     */
    override fun getAllStores(callback: Callback<StoreListResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getAllStores()
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
     * Returns all the stores for the biz
     */
    override fun getAllStores(): Observable<StoreListResponse> {
        return generalRetrofitService.getAllStores(authToken)
    }

}