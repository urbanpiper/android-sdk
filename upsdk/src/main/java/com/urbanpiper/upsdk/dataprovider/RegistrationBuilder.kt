package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.UserCreateResponse
import com.urbanpiper.upsdk.model.networkresponse.VerifyOTPResponse
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

    private var response: UserCreateResponse? = null

    fun createUser(
        phone: String, email: String, password: String, name: String, callback: Callback<UserCreateResponse>
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

    fun createUser(
        phone: String, email: String, password: String, name: String
    ): Observable<UserCreateResponse> {

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


    fun verifyOTP(phone: String, name: String, pin: String, callback: Callback<VerifyOTPResponse>): CancellableTask {
        assert(response != null)
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

    fun verifyOTP(phone: String, name: String, pin: String): Observable<VerifyOTPResponse> {
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



}