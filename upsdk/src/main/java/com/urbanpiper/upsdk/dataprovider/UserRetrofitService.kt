package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.*
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import retrofit2.http.*

interface UserRetrofitService {

    /**
     * Observable to login with JWT authentication
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
     * Observable to refresh the JWT token
     *
     * @param authToken - biz auth token
     * @param body -
     */
    @POST("/api/v2/auth/refresh-token/")
    fun refreshToken(
        @Header("Authorization") authToken: String,
        @Body body: JWTRefreshTokenBody
    ): Observable<AuthSuccessResponse>

    /**
     * For creating a new user account.
     *
     * @param authToken - Auth token
     * @param customerPhone - phone
     * @param email - email
     * @param password - password
     * @param customerName - name
     * @param channel - channel = app_android
     */
    @POST("/api/v2/card/")
    fun createUser(
        @Header("Authorization") authToken: String,
        @Query("customer_phone") customerPhone: String,
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("customer_name") customerName: String,
        @Query("channel") channel: String,
        @Body body: AccountRegistrationBody?
    ): Observable<RegistrationResponse>

    /**
     * Verify OTP after sign-in up with OTP
     *
     * @param authToken - Auth Token
     * @param body - Object of verify OTP body
     */
    @POST("/api/v2/card/?nopinsend=true")
    fun verifyOTP(
        @Header("Authorization") authToken: String,
        @Body body: VerifyOTPBody
    ): Observable<RegistrationResponse>

    /**
     * Resend OTP
     *
     * @param authToken - Auth token
     * @param body - Object of verify OTP body , No need to send HTTP Body
     */
    @POST("/api/v2/card/?pin=resendotp")
    fun resendOTP(
        @Header("Authorization") authToken: String,
        @Path("customer_phone") phone: String
    ): Observable<RegistrationResponse>

    /**
     * Observable to perform social login
     *
     * @param authToken - biz auth token
     * @param bizId - Biz id
     * @param email - email id of the user performing social login
     * @param provider - provider ( google, fb...)
     * @param accessToken - token
     * @param action -
     * @param phone - phone number
     * @param otp - OTP
     *
     */
    @GET("/api/v2/social_auth/me/")
    fun socialLogin(
        @Header("Authorization") authToken: String,
        @Query("biz_id") bizId: String,
        @Query("email") email: String,
        @Query("provider") provider: String,
        @Query("access_token") accessToken: String,
        @Query("action") phone: String,
        @Query("phone") action: String,
        @Query("otp") otp: String
    ): Observable<SocialAuthResponse>

    /**
     * Observable to perform social login
     *
     * @param authToken - biz auth token
     * @param bizId - Biz id
     * @param email - email id of the user performing social login
     * @param provider - provider ( google, fb...)
     * @param accessToken - token
     *
     */
    @GET("/api/v2/social_auth/me/")
    fun socialLogin(
        @Header("Authorization") authToken: String,
        @Query("biz_id") bizId: String,
        @Query("email") email: String,
        @Query("provider") provider: String,
        @Query("access_token") accessToken: String
    ): Observable<SocialAuthResponse>

    /**
     * Checks if the phone number is already present in the server
     *
     * @param authToken - Auth token
     * @param bizId - biz id
     * @param email - email
     * @param phone - phone
     * @param provider - provider
     * @param accessToken - access Token
     */
    @GET("/api/v2/social_auth/me/")
    fun verifyPhone(
        @Header("Authorization") authToken: String,
        @Query("biz_id") bizId: String,
        @Query("email") email: String,
        @Query("phone") phone: String,
        @Query("provider") provider: String,
        @Query("access_token") accessToken: String
    ): Observable<SocialAuthResponse>

    /**
     * Returns The user info
     *
     * @param authToken - Authorization token
     * @param phone - Phone number
     */
    @GET("/api/v1/user/profile/")
    fun refreshUserInfo(
        @Header("Authorization") authToken: String,
        @Query("customer_phone") phone: String
    ): Observable<UserInfoResponse>

    /**
     * Updates the user info
     *
     * @param authToken - Authorization token
     * @param phone - Phone number
     * @param body - Object of type UserInfoUpdateBody
     */
    @PUT("/api/v1/user/profile/")
    fun updateUserInfo(
        @Header("Authorization") authToken: String,
        @Query("customer_phone") phone: String,
        @Body body: UpdateUserInfoBody
    ): Observable<UpdateUserInfoResponse>


    /**
     * Refresh the user biz info
     *
     */
    @GET("/api/v1/userbizinfo/")
    fun refreshUserBizInfo(
        @Header("Authorization") authToken: String,
        @Query("biz_id") bizId: String
    ): Observable<UserBizInfoResponse>

    /**
     * change the password
     */
    @PUT("/api/v1/user/password/")
    fun changePassword(
        @Header("Authorization") authToken: String,
        @Body body: ChangePasswordBody
    ): Observable<GenericResponse>

    // ---------- Address related endpoints ----------
    /**
     * Gets a list of addresses for the user. Each address has a field deliverable which
     * will be true/false based on the current location id.
     *
     * @param authToken - It is logged in user auth
     * @param location  - Location id of the store
     */
    @GET("/api/v1/user/address/")
    fun getDeliverableAddress(
        @Header("Authorization") authToken: String,
        @Query("location_id") locationId: String
    ): Observable<DeliverableAddressResponse>

    /**
     * For saving a user's address for order delivery.
     *
     * @param authToken
     */
    @POST("/api/v1/user/address/?format=json")
    fun addAddress(
        @Header("Authorization") authToken: String,
        @Body body: UserAddress
    ): Observable<UserAddressSaveResponse>

    /**
     * For updating an address
     *
     * @param authToken
     */
    @POST("/api/v1/user/address/?format=json")
    fun updateAddress(
        @Header("Authorization") authToken: String,
        @Body body: UserAddress
    ): Observable<UserAddressSaveResponse>

    /**
     * Deletes a previously stored user address.
     *
     * @param authToken
     * @param addressId
     */
    @DELETE("/api/v1/user/address/{address_id}/")
    fun deleteAddress(
        @Header("Authorization") authToken: String,
        @Path("address_id") addressId: String
    ): Observable<UserAddressSaveResponse>

    // ------- wallet related endpoints -----------
    /**
     *  Returns wallet transaction's of the user
     *
     *  @param authToken -
     *  @param limit -
     *  @param offset -
     *
     */
    @GET("/api/v2/ub/wallet/transactions/")
    fun getWalletTransactions(
        @Header("Authorization") authToken: String,
        @Query("limit") limit: String,
        @Query("offset") offset: String
    ): Observable<TransactionsResponse>

    /**
     * Fetches the summary data for orders placed in the past by a
     * user.
     *
     * @param authToken - Authorization token
     */
    @GET("/api/v2/orders/")
    fun getPastOrders(
        @Header("Authorization") authToken: String
    ): Observable<OrderHistoryResponse>

    /**
     * Fetches the summary data for orders placed in the past by a
     * user.
     *
     * @param authToken
     */
    @GET("/api/v2/orders/{order_id}/")
    fun getPastOrderDetails(
        @Header("Authorization") authToken: String,
        @Path("order_id") orderId: Int
    ): Observable<OrderDetailResponse>

    /**
     * Redeem a reward
     */
    @POST("/api/v2/rewards/{rewards_id}/redeem/")
    fun redeemReward(
        @Header("Authorization") authToken: String,
        @Path("rewards_id") rewardId: Int,
        @Body blank: String
    ): Observable<RedeemRewardResponse>

    /**
     * Retrieves the list of notifications available for the user.
     *
     * @param authToken: only supports user-auth.
     */
    @GET("/api/v1/ub/notifications/?channel__in=app_notification,all")
    fun getNotifications(
        @Header("Authorization") authToken: String
    ): Observable<UserBizNotificationsResponse>

    /**
     * For saving the feedback associated with an order.
     *
     * @param authToken
     * @param feedback
     */
    @POST("/api/v2/feedback/")
    fun submitFeedback(
        @Header("Authorization") authToken: String,
        @Body feedback: UserFeedback
    ): Observable<SimpleResponse>

    /**
     * For getting list of likes
     *
     * @param authToken
     */
    @GET("/api/v1/user/item/likes/")
    fun getUserLikes(
        @Header("Authorization") authToken: String,
        @Query("item_ids") ids: String
    ): Observable<UserLikesResponse>

    /**
     * Like item.
     * Retrofit will throw you error if you send post request without Body.
     *
     * @param authToken
     */
    @POST("/api/v1/user/item/{item_id}/like/")
    fun likeItem(
        @Header("Authorization") authToken: String,
        @Path("item_id") itemId: Int,
        @Body blank: String
    ): Observable<Like>

    /**
     * Unlike the item.
     *
     * @param authToken
     */
    @DELETE("/api/v1/user/item/{item_id}/like/")
    fun unLikeItem(
        @Header("Authorization") authToken: String,
        @Path("item_id") itemId: Int
    ): Observable<Like>

    /**
     * Generate a token for forgot password
     *
     * @param authToken
     * @param body
     */
    @POST("/api/v1/user/password/token/")
    fun getResetPasswordToken(
        @Header("Authorization") authToken: String,
        @Body body: ForgotPwdGenerateTokenReq
    ): Observable<GenericResponse>

    /**
     * API call to reset password
     *
     * @param authToken
     * @param body
     */
    @POST("/api/v1/user/password/")
    fun resetPassword(
        @Header("Authorization") authToken: String,
        @Body body: ForgotPwdGenerateTokenReq
    ): Observable<GenericResponse>
}



