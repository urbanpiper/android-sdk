package com.urbanpiper.upsdk.dataprovider

import android.content.Context
import com.urbanpiper.upsdk.model.FCMRegistrationBody
import com.urbanpiper.upsdk.model.networkresponse.StoreListResponse
import com.urbanpiper.upsdk.model.networkresponse.VersionCheckResponse
import com.urbanpiper.upsdk.model.networkresponse.StoreReponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class GeneralServiceDefault(private val context: Context, private val bizId: String, retrofit: Retrofit) :
    GeneralService {

    private val generalRetrofitService: GeneralRetrofitService =
        retrofit.create(GeneralRetrofitService::class.java)

    /**
     * returns the latest version of the android app as configured on the server
     *
     * This can be used to force update the application. The response has a field that shows if force update
     * is required. This method should be called when the app is opened and after the user sign's in.
     *
     * @param username - username of the user
     * @param version - version of the application
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun checkAppVersion(
        username: String, version: String, callback: Callback<VersionCheckResponse>
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
     * returns the latest version of the android app as configured on the server
     *
     * This can be used to force update the application. The response has a field that shows if force update
     * is required. This method should be called when the app is opened and after the user sign's in.
     *
     * @param username - username of the user
     * @param version - version of the application
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun checkAppVersion(username: String, version: String): Observable<VersionCheckResponse> {
        val authToken: String = Utils().getAuthToken(context, false)
        return generalRetrofitService.appVersionCheck(authToken, bizId, username, version)
    }

    /**
     * Register the device for FCM
     *
     * This can be used to force update the application. The response has a field that shows if force update
     * is required. This method should be called when the app is opened and after the user sign's in.
     *
     * @param token - FCM registration token
     * @param deviceId - The unique id of the device
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * This method registers a device to receive FCM messages, This should be called when the app
     * is launched and after the user sign's in to the app
     *
     * @param token - FCM registration token
     * @param deviceId - The unique id of the device
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun registerFCMToken(token: String, deviceId: String): Observable<Void> {
        val authToken: String = Utils().getAuthToken(context, Utils().isUserLoggedIn(context))
        val fcmRegistrationBody = FCMRegistrationBody(token, deviceId)
        return generalRetrofitService.registerDeviceForFCM(fcmRegistrationBody, authToken)
    }

    /**
     * Returns the nearest store based on lat/ lng
     *
     * This endpoint helps determine the nearest store from which an order can be delivered.
     * It expects the latitude/longitude information of the location to be delivered to.
     * Along with the store information, this endpoint also returns the biz related information,
     * which can be cached for later use.
     *
     * @param lat - User's latitude
     * @param lng - User's longitude
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     *
     * This endpoint helps determine the nearest store from which an order can be delivered.
     * It expects the latitude/longitude information of the location to be delivered to.
     * Along with the store information, this endpoint also returns the biz related information,
     * which can be cached for later use.
     *
     * @param lat - User's latitude
     * @param lng - User's longitude
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getNearestStore(lat: Double, lng: Double): Observable<StoreReponse> {
        val authToken: String = Utils().getAuthToken(context, false)
        return generalRetrofitService.getNearestStore(authToken, lat, lng, bizId)
    }

    /**
     * Returns all the stores for the business
     *
     * This method returns all the stores configured for a business.
     *
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * Returns all the stores for the business
     *
     * This method returns all the stores configured for a business.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getAllStores(): Observable<StoreListResponse> {
        val authToken: String = Utils().getAuthToken(context, false)
        return generalRetrofitService.getAllStores(authToken)
    }

}