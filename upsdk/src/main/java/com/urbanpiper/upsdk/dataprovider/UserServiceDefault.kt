package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.JWTAuthLoginBody
import com.urbanpiper.upsdk.model.JWTRefreshTokenBody
import com.urbanpiper.upsdk.model.networkresponse.AuthSuccessResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class UserServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) : UserService {

    private val authRetrofitService: UserRetrofitService =
        retrofit.create(UserRetrofitService::class.java)

    override fun login(body: JWTAuthLoginBody, callback: Callback<AuthSuccessResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            login(body)
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

    override fun login(body: JWTAuthLoginBody): Observable<AuthSuccessResponse> {
        return authRetrofitService.login(authToken, body)
    }

    override fun refreshToken(body: JWTRefreshTokenBody, callback: Callback<AuthSuccessResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            refreshToken(body)
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

    override fun refreshToken(body: JWTRefreshTokenBody): Observable<AuthSuccessResponse> {
        return authRetrofitService.refreshToken(authToken, body)
    }
}