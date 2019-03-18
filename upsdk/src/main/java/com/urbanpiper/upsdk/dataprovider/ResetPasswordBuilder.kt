package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.GenericResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ResetPasswordBuilder(private val userServiceDefault: UserServiceDefault) {

    private var response: GenericResponse? = null
    /**
     * This method generates a password reset token that is sent to the user through
     * SMS and phone
     *
     * @param phone - Phone number
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getResetPasswordToken(phone: String, callback: Callback<GenericResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getResetPasswordToken(phone)
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
     * This method generates a password reset token that is sent to the user through
     * SMS and phone
     *
     * @param phone - Phone number
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getResetPasswordToken(phone: String): Observable<GenericResponse> {

        val observable = userServiceDefault.getResetPasswordToken(phone).share()

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
     * This method reset's the password after the user enter's the password reset token sent
     * through SMS and email
     *
     * The password has to be sent twice so that the server can verify it
     *
     * @param phone - Phone number
     * @param newPassword - New password
     * @param confirmPassword - Confirm same password
     * @param token - Token the user input's
     * @param callback - Callback to return the result
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun resetPassword(
        phone: String, newPassword: String, confirmPassword: String, token: String,
        callback: Callback<GenericResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            resetPassword(phone, newPassword, confirmPassword, token)
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
     * This method reset's the password after the user enter's the password reset token sent
     * through SMS and email
     *
     * The password has to be sent twice so that the server can verify it
     *
     * @param phone - Phone number
     * @param newPassword - New password
     * @param confirmPassword - Confirm same password
     * @param token - Token the user input's
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun resetPassword(
        phone: String, newPassword: String, confirmPassword: String, token: String
    ): Observable<GenericResponse> {
        assert(response != null)

        val observable = userServiceDefault.resetPassword(phone, newPassword, confirmPassword, token).share()

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