package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.SocialAuthResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SocialRegBuilder(private val userServiceDefault: UserServiceDefault) {

    var response1: SocialAuthResponse? = null
    var response2: SocialAuthResponse? = null

    /**
     * TODO
     *
     * @param email - email
     * @param provider - provider
     * @param accessToken - access token from facebook or google
     * @param callback - callback to return the result
     */
    fun socialLogin(
        email: String, provider: String, accessToken: String, callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            socialLogin(email, provider, accessToken)
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
     * TODO
     *
     * @param email - email
     * @param provider - provider
     * @param accessToken - access token from facebook or google
     */
    fun socialLogin(email: String, provider: String, accessToken: String): Observable<SocialAuthResponse> {
        val observable = userServiceDefault.socialLogin(email, provider, accessToken).share()

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    response1 = success
                }, { error ->
                    response1 = null
                })
        )
        return observable
    }

    /**
     * TODO
     *
     * @param email - email
     * @param provider - provider
     * @param accessToken - accessToken
     * @param action - action
     * @param phone - phone
     * @param otp - otp
     * @param callback - Callback to return the result
     */
    fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String, otp: String,
        callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            socialLoginOTP(email, provider, accessToken, phone, action, otp)
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
     * TODO
     *
     * @param email - email
     * @param provider - provider
     * @param accessToken - accessToken
     * @param action - action
     * @param phone - phone
     * @param otp - otp
     */
    fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String, otp: String
    ): Observable<SocialAuthResponse> {
        assert(response1 != null)
        val observable = userServiceDefault.socialLoginOTP(email, provider, accessToken, action, phone, otp).share()

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    response2 = success
                }, { error ->
                    response2 = null
                })
        )
        return observable
    }





}