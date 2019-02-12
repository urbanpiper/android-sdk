package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.JWTAuthLoginBody
import com.urbanpiper.upsdk.model.JWTRefreshTokenBody
import com.urbanpiper.upsdk.model.networkresponse.AuthSuccessResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface UserRetrofitService {

    /**
     * Call to login with JWT authentication
     *
     * @param authToken - Biz auth token
     * @param body - Pass the body auth retrofit
     */
    @POST("/api/v2/auth/token/")
    fun login(
        @Header("Authorization") authToken: String,
        @Body body: JWTAuthLoginBody
    ): Call<AuthSuccessResponse>

    /**
     * Call to refresh the JWT token
     *
     * @param authToken - biz auth token
     * @param body -
     */
    @POST("/api/v2/auth/refresh-token/")
    fun refreshToken(
        @Header("Authorization") authToken: String,
        @Body body: JWTRefreshTokenBody
    ): Call<AuthSuccessResponse>

}