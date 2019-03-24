package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.RegistrationResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Registration builder
 *
 * There are two steps
 * 1. First you have to create a new user
 * 2. Verify OTP
 *
 * @property userServiceDefault
 */
class RegistrationBuilder(private var userServiceDefault: UserServiceDefault) {

    private var response: RegistrationResponse? = null

    /**
     * This method is used to register a new user
     *
     * @param phone - Phone number
     * @param email - Email
     * @param password - Password
     * @param name - Name
     * @param callback - Callback
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
     * This method is used to register a new user
     *
     * @param phone - Phone number
     * @param email - Email
     * @param password - Password
     * @param name - Name
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
                    response = success
                }, { failure ->
                    response = null
                })
        )

        return observable
    }

    /**
     * This method is used to verify the OTP
     *
     * @param phone - Phone number
     * @param pin - pin
     * @param name - name
     * @param callback - callback to return the result
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
     * This method is used to verify the OTP
     *
     * @param phone - Phone number
     * @param pin - Pin
     * @param name - Name
     */
    fun verifyOTP(phone: String, name: String, pin: String): Observable<RegistrationResponse> {
        assert(response != null)
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