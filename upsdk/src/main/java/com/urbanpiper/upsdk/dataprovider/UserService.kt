package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.UpdateUserInfoBody
import com.urbanpiper.upsdk.model.networkresponse.*
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
     * Social login - the result is returned as a callback
     */
    fun socialLogin(
        email: String, provider: String, accessToken: String,
        callback: Callback<SocialAuthResponse>
    ): CancellableTask

    /**
     * Social login - The result is returned as an observable
     */
    fun socialLogin(email: String, provider: String, accessToken: String): Observable<SocialAuthResponse>

    /**
     *  Refresh user info - The result is returned as a callback
     */
    fun refreshUserInfo(phone: String, callback: Callback<UserInfoResponse>): CancellableTask

    /**
     *  Refresh user info - The result is returned as a Observable
     */
    fun refreshUserInfo(phone: String): Observable<UserInfoResponse>

    /**
     * Update user info - The result is returned as a callback
     */
    fun updateUserInfo(
        phone: String, body: UpdateUserInfoBody, callback: Callback<UpdateUserInfoResponse>
    ): CancellableTask

    /**
     * Update user info - the result is returned as a observable
     */
    fun updateUserInfo(phone: String, body: UpdateUserInfoBody): Observable<UpdateUserInfoResponse>

    /**
     * Refresh User Biz info - The result is returned as a callback
     */
    fun refreshUserBizInfo(callback: Callback<UserBizInfoResponse>): CancellableTask

    /**
     * Refresh User Biz info - the result is returned as a observable
     */
    fun refreshUserBizInfo(): Observable<UserBizInfoResponse>

    /**
     * change the password - The result is returned as a callback
     */
    fun changePassword(
        oldPassword: String, newPassword: String, confirmPassword: String, phone: String,
        callback: Callback<GenericResponse>
    ): CancellableTask

    /**
     * change the password - The result tis returned as an Observable
     */
    fun changePassword(
        oldPassword: String, newPassword: String, confirmPassword: String, phone: String
    ): Observable<GenericResponse>

    /**
     * get Deliverable address - The result is returned as a callback
     */
    fun getDeliverableAddresses(locationId: String, callback: Callback<DeliverableAddressResponse>): CancellableTask

    /**
     * get Deliverable address - The result is returned as a observable
     */
    fun getDeliverableAddresses(locationId: String): Observable<DeliverableAddressResponse>

    /**
     * Add an address - The result is a callback
     */
    fun addAddress(userAddress: UserAddress, callback: Callback<UserAddressSaveResponse>): CancellableTask

    /**
     * add an address
     */
    fun addAddress(userAddress: UserAddress): Observable<UserAddressSaveResponse>

    /**
     * Update an address
     */
    fun updateAddress(userAddress: UserAddress, callback: Callback<UserAddressSaveResponse>): CancellableTask

    /**
     * Update an existing address
     */
    fun updateAddress(userAddress: UserAddress): Observable<UserAddressSaveResponse>

    /**
     * Delete an existing address
     */
    fun deleteAddress(addressId: String, callback: Callback<UserAddressSaveResponse>): CancellableTask

    /**
     * Delete an existing address
     */
    fun deleteAddress(addressId: String): Observable<UserAddressSaveResponse>

    /**
     *  Returns wallet transaction's of the user
     */
    fun getWalletTransactions(limit: String, offset: String, callback: Callback<TransactionsResponse>): CancellableTask

    /**
     *  Returns wallet transaction's of the user
     */
    fun getWalletTransactions(limit: String, offset: String): Observable<TransactionsResponse>

    /**
     * Fetches the summary data for orders placed in the past by a
     * user.
     */
    fun getPastOrders(callback: Callback<OrderHistoryV2Response>): CancellableTask

    /**
     * Fetches the summary data for orders placed in the past by a
     * user.
     */
    fun getPastOrders(): Observable<OrderHistoryV2Response>

    /**
     * Fetches the summary data for orders placed in the past by a
     * user
     */
    fun getPastOrderDetails(orderId: Int, callback: Callback<OrderDetailResponse>): CancellableTask

    /**
     * Fetches the summary data for orders placed in the past by a
     * user
     */
    fun getPastOrderDetails(orderId: Int): Observable<OrderDetailResponse>

    /**
     * Redeem a reward
     */
    fun redeemReward(rewardId: Int, callback: Callback<RedeemRewardResponse>): CancellableTask

    /**
     * Redeem a reward
     */
    fun redeemReward(rewardId: Int): Observable<RedeemRewardResponse>

    /**
     *  Retrieves the list of notifications available for
     * the user.
     */
    fun getNotifications(callback: Callback<UserbizNotificationsResponse>): CancellableTask

    /**
     *  Retrieves the list of notifications available for
     * the user.
     */
    fun getNotifications(): Observable<UserbizNotificationsResponse>

    /**
     * For saving the feedback associated with an order.
     */
    fun submitFeedback(feedback: UserFeedback, callback: Callback<SimpleResponse>): CancellableTask

    /**
     * For saving the feedback associated with an order.
     */
    fun submitFeedback(feedback: UserFeedback): Observable<SimpleResponse>

    /**
     * For getting list of likes
     */
    fun getUserLikes(ids: String, callback: Callback<UserLikesResponse>): CancellableTask

    /**
     * For getting list of likes
     */
    fun getUserLikes(ids: String): Observable<UserLikesResponse>

    /**
     * like item
     */
    fun likeItem(itemId: Int, callback: Callback<Like>): CancellableTask

    /**
     * like item
     */
    fun likeItem(itemId: Int): Observable<Like>

    /**
     * unlike item
     */
    fun unLikeItem(itemId: Int, callback: Callback<Like>): CancellableTask

    /**
     * unlike item
     */
    fun unLikeItem(itemId: Int): Observable<Like>
}
