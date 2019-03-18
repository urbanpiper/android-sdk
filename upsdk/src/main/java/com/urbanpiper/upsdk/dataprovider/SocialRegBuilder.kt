package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.RegistrationResponse
import com.urbanpiper.upsdk.model.networkresponse.SocialAuthResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * A helper class that contains the related api's to register a social login user.
 * The api's have to be called in the following order.
 *
 *`verifyPhone(...)`, function to verify the phone number provided by an unregistered social login user,
 * sends an OTP to the phone number passed on success, if the message variable is "new_registration_required"
 * the user has be registered using the `registerSocialUser(...)`, call, else the user's phone number is already
 * present in the system and the phone number needs to be verified by the `verifySocialOTP(...)`, call
 *
 * - `registerSocialUser(...)`, function to register a new social login user if the message variable in verifyPhone
 * response is "new_registration_required"
 *
 * - `verifyRegOTP(...)`, function to verify the phone number passed in by the user if the message variable in
 * verifyPhone response is "new_registration_required"
 *
 * - `resendRegOTP(...)`, function to resend a new otp to the user's phone number passed in by the user
 * if the message variable in verifyPhone response is "new_registration_required"
 *
 * - `verifySocialOTP(...)`, function to verify the phone number passed in by the user if the message
 * variable in verifyPhone response is not "new_registration_required"
 *
 * - `resendSocialOTP(...)`, function to resend a new otp to the user's phone number passed in by the user
 * if the message variable in verifyPhone response is not "new_registration_required"
 *
 * @property userServiceDefault - An instance of userServiceDefault must be passed into the builder
 */
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
    fun verifySocialOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String, otp: String,
        callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            verifySocialOTP(email, provider, accessToken, phone, action, otp)
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
     * Verifies Social Login OTP
     *
     * @param email - email
     * @param provider - provider
     * @param accessToken - accessToken
     * @param action - action
     * @param phone - phone
     * @param otp - otp
     */
    fun verifySocialOTP(
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
     * Create a new user
     *
     * @param phone
     * @param email
     * @param password
     * @param name
     * @param callback
     */
    fun createSocialUser(
        phone: String, email: String, password: String, name: String, callback: Callback<RegistrationResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            createSocialUser(phone, email, password, name)
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
     * create a new user
     *
     * @param phone
     * @param email
     * @param password
     * @param name
     */
    fun createSocialUser(
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
     * verify OTP
     *
     * @param phone
     * @param name
     * @param pin
     * @param callback
     */
    fun verifyRegOTP(phone: String, name: String, pin: String, callback: Callback<RegistrationResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            verifyRegOTP(phone, name, pin)
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
     * Verify OTP
     *
     * @param phone
     * @param name
     * @param pin
     */
    fun verifyRegOTP(phone: String, name: String, pin: String): Observable<RegistrationResponse> {
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
    fun resendRegOTP(phone: String, callback: Callback<RegistrationResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            resendRegOTP(phone)
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
    fun resendRegOTP(phone: String): Observable<RegistrationResponse> {
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