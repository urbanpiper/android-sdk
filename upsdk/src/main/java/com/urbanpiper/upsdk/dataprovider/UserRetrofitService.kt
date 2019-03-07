package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.ChangePasswordBody
import com.urbanpiper.upsdk.model.JWTAuthLoginBody
import com.urbanpiper.upsdk.model.JWTRefreshTokenBody
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import retrofit2.http.*

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
    fun updateUserSettings(
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
        @Query("biz_id") bizId: String,
        @Header("Authorization") authToken: String
    ): Observable<UserBizInfoResponse>

    /**
     * Update the password
     *
     */
    @PUT("/api/v1/user/password/")
    fun changePassword(
        @Header("Authorization") apiAuth: String,
        @Body body: ChangePasswordBody
    ): Observable<GenericResponse>

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
        @Query("location_id") location: String
    ): Observable<DeliverableAddressResponse>

    // ---------- Address related endpoints ----------
    /**
     * For saving a user's address for order delivery.
     *
     * @param authToken
     */
    @POST("/api/v1/user/address/?format=json")
    fun addAddress(
        @Header("Authorization") authToken: String,
        @Body address: UserAddress
    ): Observable<UserAddressSaveResponse>

    /**
     * For updating an address
     *
     * @param authToken
     */
    @POST("/api/v1/user/address/?format=json")
    fun updateAddress(
        @Header("Authorization") authToken: String,
        @Body address: UserAddress
    ): Observable<UserAddressSaveResponse>

    /**
     * Deletes a previously stored user address.
     *
     * @param authToken
     * @param addressId
     * @param cb
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
    ): Observable<OrderHistoryV2Response>

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


    @POST("/api/v2/rewards/{rewards_id}/redeem/")
    fun redeemReward(
        @Header("Authorization") authToken: String,
        @Path("rewards_id") rewardId: Int,
        @Body blank: String
    ): Observable<RedeemRewardResponse>

    /**
     * Retrieves the list of notifications available for
     * the user.
     *
     * @param authToken: only supports user-auth.
     */
    @GET("/api/v1/ub/notifications/?channel__in=app_notification,all")
    fun getNotifications(
        @Header("Authorization") authToken: String
    ) :Observable<UserbizNotificationsResponse>

    /**
     * For saving the feedback associated with an order.
     *
     * @param authToken
     * @param feedback
     * @param cb
     */
    @POST("/api/v2/feedback/")
    fun submitFeedback(
        @Header("Authorization") authToken: String,
        @Body feedback: UserFeedback
    ) : Observable<SimpleResponse>

    /** For getting list of likes
     *
     * @param apiAuth
     * @param cb
     */
    @GET("/api/v1/user/item/likes/")
    fun getUserLikes(
        @Header("Authorization") apiAuth: String,
        @Query( "item_ids") ids: String
    ) : Observable<UserLikesResponse>


    /**
     * Like item.
     * Retrofit will throw you error if you send post request without Body.
     *
     * @param apiAuth
     */
    @POST("/api/v1/user/item/{item_id}/like/")
    fun likeItem(
        @Header("Authorization") apiAuth: String,
        @Path("item_id") itemId: Int,
        @Body hello: String
    ): Observable<Like>

    /**
     * Unlike the item.
     *
     * @param apiAuth
     */
    @DELETE("/api/v1/user/item/{item_id}/like/")
    fun unLikeItem(
        @Header("Authorization") apiAuth: String,
        @Path("item_id") itemId: Int
    ): Observable<Like>
}


