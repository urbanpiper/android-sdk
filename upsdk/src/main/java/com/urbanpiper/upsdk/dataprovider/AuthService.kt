package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.JWTAuthLoginBody
import com.urbanpiper.upsdk.model.JWTRefreshTokenBody
import com.urbanpiper.upsdk.model.networkresponse.AuthSuccessResponse
import retrofit2.Callback

interface AuthService {

    fun login(body: JWTAuthLoginBody, callback: Callback<AuthSuccessResponse>): CancellableTask

    fun refreshToken(body: JWTRefreshTokenBody, callback: Callback<AuthSuccessResponse>) : CancellableTask

}