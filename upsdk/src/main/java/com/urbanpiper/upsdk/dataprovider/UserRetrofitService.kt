package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.JWTAuthLoginBody
import com.urbanpiper.upsdk.model.JWTRefreshTokenBody
import com.urbanpiper.upsdk.model.networkresponse.AuthSuccessResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface UserRetrofitService {

    /**
     * io.reactivex.Observable to login with JWT authentication
     *
     * @param authToken - Biz auth token
     * @param body - Pass the body auth retrofit
     */
    @POST("/api/v2/auth/token/")
    fun login(
        @Header("Authorization") authToken: String,
        @Body body: JWTAuthLoginBody
    ): Observable<AuthSuccessResponse>

    /**
     * io.reactivex.Observable to refresh the JWT token
     *
     * @param authToken - biz auth token
     * @param body -
     */
    @POST("/api/v2/auth/refresh-token/")
    fun refreshToken(
        @Header("Authorization") authToken: String,
        @Body body: JWTRefreshTokenBody
    ): Observable<AuthSuccessResponse>

}