package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.AuthSuccessResponse
import com.urbanpiper.upsdk.model.networkresponse.SocialAuthResponse
import com.urbanpiper.upsdk.model.networkresponse.UserInfoResponse
import io.reactivex.Observable

interface UserService {

    /**
     *  Login - The result is returned in a callback
     */
    fun login(phone: String, password: String, callback: Callback<AuthSuccessResponse>): CancellableTask

    /**
     *  Login - The result is returned as an Observable
     */
    fun login(phone: String, password: String): Observable<AuthSuccessResponse>

    /**
     * Refresh Token - the result is returned as a callback
     */
    fun refreshToken(token: String, callback: Callback<AuthSuccessResponse>): CancellableTask

    /**
     * refresh token - The result is returned as an observable
     */
    fun refreshToken(token: String): Observable<AuthSuccessResponse>

    /**
     * Social login - the result is returned as a callback
     *
     */
    fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String,
        otp: String, callback: Callback<SocialAuthResponse>
    ): CancellableTask

    /**
     * Social login - The result is returned as an observable
     *
     */
    fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String,
        otp: String
    ): Observable<SocialAuthResponse>

    /**
     *  Refresh user info - The result is returned as a callback
     */
    fun refreshUserInfo(phone: String, callback: Callback<UserInfoResponse>): CancellableTask

    /**
     *  Refresh user info - The result is returned as a Observable
     */
    fun refreshUserInfo(phone: String): Observable<UserInfoResponse>

    /**
     * Social login - the result is returned as a callback
     */
    fun socialLogin(email: String, provider: String, accessToken: String,
        callback: Callback<SocialAuthResponse>
    ): CancellableTask

    /**
     * Social login - The result is returned as an observable
     */
    fun socialLogin(email: String, provider: String, accessToken: String): Observable<SocialAuthResponse>
}
