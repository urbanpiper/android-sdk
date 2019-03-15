package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.RegistrationResponse
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
     * Check if phone number is present in the server. It will also send an OTP if the user is present
     * in the server, or you will have to create a new user
     *
     * @param email - Email
     * @param phone - Phone
     * @param provider - Provider
     * @param accessToken - Access Token for google / facebook
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun verifyPhone(
        email: String, phone: String, provider: String, accessToken: String, callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            verifyPhone(email, phone, provider, accessToken)
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
     * Check if phone number is present in the server. It will also send an OTP if the user is present
     * in the server, or you will have to create a new user
     *
     * @param email - Email
     * @param phone - Phone
     * @param provider - Provider
     * @param accessToken - Access Token for google / facebook
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun verifyPhone(
        email: String, phone: String, provider: String, accessToken: String
    ): Observable<SocialAuthResponse> {
        val observable = userServiceDefault.verifyPhone(email, phone, provider, accessToken).share()

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                }, { error ->
                })
        )
        return observable
    }

    /**
     * Resend Social OTP
     *
     * @param email - Email
     * @param phone - Phone
     * @param provider - Provider
     * @param accessToken - Access Token for google / facebook
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun resendSocialOtp(
        email: String, phone: String, provider: String, accessToken: String, callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        return verifyPhone(email, phone, provider, accessToken, callback)
    }

    /**
     * Resend Social OTP
     *
     * @param email - Email
     * @param phone - Phone
     * @param provider - Provider
     * @param accessToken - Access Token for google / facebook
     */
    fun resendSocialOtp(
        email: String, phone: String, provider: String, accessToken: String
    ): Observable<SocialAuthResponse> {
        return verifyPhone(email, phone, provider, accessToken)
    }

    /**
     * Resend Social login OTP
     *
     * @param email - email
     * @param provider - provider
     * @param accessToken - accessToken
     * @param action - action
     * @param phone - phone
     * @param otp - otp
     * @param callback - Callback to return the result
     *
     * @return Observable - the result of the network request is returned as an Observable
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

    /**
     * TODO
     *
     * @param phone
     * @param email
     * @param password
     * @param name
     * @param callback
     */
    fun createUser(
        phone: String, email: String, password: String, name: String, callback: Callback<RegistrationResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            createUser(phone, email, password, name)
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
     * @param phone
     * @param email
     * @param password
     * @param name
     */
    fun createUser(
        phone: String, email: String, password: String, name: String
    ): Observable<RegistrationResponse> {

        val observable = userServiceDefault.registerUser(phone, email, password, name).share()

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->

                }, { failure ->
                })
        )

        return observable
    }

    /**
     * TODO
     *
     * @param phone
     * @param name
     * @param pin
     * @param callback
     */
    fun verifyOTP(phone: String, name: String, pin: String, callback: Callback<RegistrationResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            verifyOTP(phone, name, pin)
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
     * @param phone
     * @param name
     * @param pin
     */
    fun verifyOTP(phone: String, name: String, pin: String): Observable<RegistrationResponse> {
        val observable = userServiceDefault.verifyOTP(phone, pin, name).share()

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                }, { failure ->
                })
        )
        return observable
    }

    /**
     * This method is used ot resend the OTP
     *
     * @param phone - Phone number
     * @param callback - callback to return the result
     */
    fun resendOTP(phone: String, callback: Callback<RegistrationResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            resendOTP(phone)
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
     * This method is used to resend the OTP
     *
     * @param phone - Phone number
     */
    fun resendOTP(phone: String): Observable<RegistrationResponse> {
        val observable = userServiceDefault.resendOTP(phone).share()

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                }, { failure ->
                })
        )
        return observable
    }


}