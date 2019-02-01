package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.JWTAuthLoginBody
import com.urbanpiper.upsdk.model.JWTRefreshTokenBody
import com.urbanpiper.upsdk.model.networkresponse.AuthSuccessResponse
import retrofit2.Callback
import retrofit2.Retrofit

class AuthServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) : AuthService {

    private val authRetrofitService: AuthRetrofitService =
        retrofit.create(AuthRetrofitService::class.java)

    override fun login(body: JWTAuthLoginBody, callback: Callback<AuthSuccessResponse>): CancellableTask {
        val loginCall = authRetrofitService.login(authToken, body)
        loginCall.clone().enqueue(callback)
        return CancellableTaskWrapper(loginCall)
    }

    override fun refreshToken(body: JWTRefreshTokenBody, callback: Callback<AuthSuccessResponse>): CancellableTask {
        val refreshTokenCall = authRetrofitService.refreshToken(authToken, body)
        refreshTokenCall.clone().enqueue(callback)
        return CancellableTaskWrapper(refreshTokenCall)
    }

}