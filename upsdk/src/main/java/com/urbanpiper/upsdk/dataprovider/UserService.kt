package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.UpdateUserInfoBody
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable

interface UserService {

    /**
     * For login the user needs to provide his/her phone number, along with the password
     * that they had set for their account.
     *
     * @param phone - Phone number of the user
     * @param password - User password
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun login(phone: String, password: String, callback: Callback<AuthSuccessResponse>): CancellableTask

    /**
     * For login the user needs to provide his/her phone number, along with the password
     * that they had set for their account.
     *
     * @param phone - Phone number of the user
     * @param password - User password
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun login(phone: String, password: String): Observable<AuthSuccessResponse>

    /**
     * We use JWT tokens for authentication, we need to use this method to get a new token
     * if the current token has completed 80% of it's lifetime
     *
     * @param token - Old token
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun refreshToken(token: String, callback: Callback<AuthSuccessResponse>): CancellableTask

    /**
     * We use JWT tokens for authentication, we need to use this method to get a new token
     * if the current token has completed 80% of it's lifetime
     *
     * @param token - Old token
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun refreshToken(token: String): Observable<AuthSuccessResponse>


    /**
     * This method is used to register a new user
     *
     * @param phone - Phone number
     * @param email - Email
     * @param password - Password
     * @param name - Name
     * @param callback - Callback
     */
    fun registerUser(
        phone: String, email: String, password: String, name: String, callback: Callback<UserCreateResponse>
    ): CancellableTask

    /**
     * This method is used to register a new user
     *
     * @param phone - Phone number
     * @param email - Email
     * @param password - Password
     * @param name - Name
     */
    fun registerUser(phone: String, email: String, password: String, name: String): Observable<UserCreateResponse>

    /**
     * This method is used to verify the OTP
     *
     * @param phone - Phone number
     * @param pin - pin
     * @param name - name
     * @param callback - callback to return the result
     */
    fun verifyOTP(phone: String, pin: String, name: String, callback: Callback<VerifyOTPResponse>): CancellableTask

    /**
     * This method is used to verify the OTP
     *
     * @param phone - Phone number
     * @param pin - Pin
     * @param name - Name
     */
    fun verifyOTP(phone: String, pin: String, name: String): Observable<VerifyOTPResponse>

    /**
     * TODO
     *
     * @param email
     * @param provider
     * @param accessToken
     * @param action
     * @param phone
     * @param otp
     * @param callback
     */
    fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String,
        otp: String, callback: Callback<SocialAuthResponse>
    ): CancellableTask

    /**
     * TODO
     *
     * @param email
     * @param provider
     * @param accessToken
     * @param action
     * @param phone
     * @param otp
     */
    fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String,
        otp: String
    ): Observable<SocialAuthResponse>

    /**
     * TODO
     *
     * @param email
     * @param provider
     * @param accessToken
     * @param callback
     */
    fun socialLogin(
        email: String, provider: String, accessToken: String,
        callback: Callback<SocialAuthResponse>
    ): CancellableTask

    /**
     * TODO
     *
     * @param email
     * @param provider
     * @param accessToken
     */
    fun socialLogin(email: String, provider: String, accessToken: String): Observable<SocialAuthResponse>

    /**
     * Returns the profile data associated with a particular user identified by his/her phone number.
     *
     * @param phone - Phone number
     * @param callback - The result is returned as a callback
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun refreshUserInfo(phone: String, callback: Callback<UserInfoResponse>): CancellableTask

    /**
     * Returns the profile data associated with a particular user identified by his/her phone number.
     *
     * @param phone - Phone number
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun refreshUserInfo(phone: String): Observable<UserInfoResponse>

    /**
     * Updates the profile data associated with a particular user identified by the phone number.
     *
     * @param phone - Phone number
     * @param body - UpdateUserInfo Object
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun updateUserInfo(
        phone: String, body: UpdateUserInfoBody, callback: Callback<UpdateUserInfoResponse>
    ): CancellableTask

    /**
     * Updates the profile data associated with a particular user identified by the phone number.
     *
     * @param phone - Phone number
     * @param body - UpdateUserInfo Object
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun updateUserInfo(phone: String, body: UpdateUserInfoBody): Observable<UpdateUserInfoResponse>

    /**
     * Returns the profile data associated with a particular user identified by his/her phone number.
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun refreshUserBizInfo(callback: Callback<UserBizInfoResponse>): CancellableTask

    /**
     * Returns the profile data associated with a particular user identified by his/her phone number.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun refreshUserBizInfo(): Observable<UserBizInfoResponse>

    /**
     * Change the password for a user, The new password has to be passed in twice so the server can
     * verify it
     *
     * @param oldPassword - Old password
     * @param newPassword - New password
     * @param confirmPassword - New password
     * @param phone - phone number
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun changePassword(
        oldPassword: String, newPassword: String, confirmPassword: String, phone: String,
        callback: Callback<GenericResponse>
    ): CancellableTask

    /**
     * Change the password for a user, The new password has to be passed in twice so the server can
     * verify it
     *
     * @param oldPassword - Old password
     * @param newPassword - New password
     * @param confirmPassword - New password
     * @param phone - phone number
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun changePassword(
        oldPassword: String, newPassword: String, confirmPassword: String, phone: String
    ): Observable<GenericResponse>

    /**
     * This method returns a list of addresses for a given location idm
     * with a field deliverable(true or false) indicating if delivery is possible for that location or not
     *
     * @param locationId - Location id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getDeliverableAddresses(locationId: String, callback: Callback<DeliverableAddressResponse>): CancellableTask

    /**
     * This method returns a list of addresses for a given location id
     * with a field deliverable(true or false) indicating if delivery is possible for that location or not
     *
     * @param locationId - Location id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getDeliverableAddresses(locationId: String): Observable<DeliverableAddressResponse>

    /**
     * This method adds a new address for the user
     *
     * @param userAddress - UserAddress Object
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun addAddress(userAddress: UserAddress, callback: Callback<UserAddressSaveResponse>): CancellableTask

    /**
     * This method adds a new address for the user
     *
     * @param userAddress - UserAddress Object
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun addAddress(userAddress: UserAddress): Observable<UserAddressSaveResponse>

    /**
     * This method adds a updates an existing address for the user
     *
     * @param userAddress - UserAddress Object
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun updateAddress(userAddress: UserAddress, callback: Callback<UserAddressSaveResponse>): CancellableTask

    /**
     * This method adds a updates an existing address for the user
     *
     * @param userAddress - UserAddress Object
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun updateAddress(userAddress: UserAddress): Observable<UserAddressSaveResponse>

    /**
     * This method deletes an existing address for a user
     *
     * @param addressId - Address id
     * @param callback - Callback
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun deleteAddress(addressId: String, callback: Callback<UserAddressSaveResponse>): CancellableTask

    /**
     * This method deletes an existing address for a user
     *
     * @param addressId - Address id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun deleteAddress(addressId: String): Observable<UserAddressSaveResponse>

    /**
     * This endpoint returns a list of prepaid transactions associated with the user.
     * Each of the transactions contains some basic information about the context of the transaction.
     * Since the white-label prepaid wallet instrument is available to the user to perform some other
     * transaction - like paying for an online order or an in-store purchase -
     * each prepaid transaction can be thought of as an enabler for an associated transaction.
     *
     * @param limit - Limit
     * @param offset - Offset
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getWalletTransactions(limit: String, offset: String, callback: Callback<TransactionsResponse>): CancellableTask

    /**
     * This endpoint returns a list of prepaid transactions associated with the user.
     * Each of the transactions contains some basic information about the context of the transaction.
     * Since the white-label prepaid wallet instrument is available to the user to perform some other
     * transaction - like paying for an online order or an in-store purchase -
     * each prepaid transaction can be thought of as an enabler for an associated transaction.
     *
     * @param limit - Limit
     * @param offset - Offset
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getWalletTransactions(limit: String, offset: String): Observable<TransactionsResponse>

    /**
     * This endpoint returns the list of orders placed by a user in the past. Only the summary data
     * for each order is returned. This should be used when a client needs to display the past orders placed
     * by a user.
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getPastOrders(callback: Callback<OrderHistoryV2Response>): CancellableTask

    /**
     * This endpoint returns the list of orders placed by a user in the past. Only the summary data
     * for each order is returned. This should be used when a client needs to display the past orders placed
     * by a user.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getPastOrders(): Observable<OrderHistoryV2Response>

    /**
     * Returns details information about an order
     *
     * @param orderId - Order id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getPastOrderDetails(orderId: Int, callback: Callback<OrderDetailResponse>): CancellableTask

    /**
     * Returns details information about an order
     *
     * @param orderId - Order id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getPastOrderDetails(orderId: Int): Observable<OrderDetailResponse>

    /**
     * This method redeems a reward for a user
     *
     * @param rewardId - Id of the reward
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun redeemReward(rewardId: Int, callback: Callback<RedeemRewardResponse>): CancellableTask

    /**
     * This method redeems a reward for a user
     *
     * @param rewardId - Id of the reward
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun redeemReward(rewardId: Int): Observable<RedeemRewardResponse>

    /**
     * This method returns a list of all the notifications that was sent to that user
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getNotifications(callback: Callback<UserbizNotificationsResponse>): CancellableTask

    /**
     * This method returns a list of all the notifications that was sent to that user
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getNotifications(): Observable<UserbizNotificationsResponse>

    /**
     * TODO
     *
     * @param feedback
     * @param callback
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun submitFeedback(feedback: UserFeedback, callback: Callback<SimpleResponse>): CancellableTask

    /**
     * TODO
     *
     * @param feedback
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun submitFeedback(feedback: UserFeedback): Observable<SimpleResponse>

    /**
     * Returns a list of likes for item id's passed as (eg - id1,id2,id3)
     *
     * @param ids - Item id's passed as a comma separated values (eg - id1,id2,id3)
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getUserLikes(ids: String, callback: Callback<UserLikesResponse>): CancellableTask

    /**
     * Returns a list of likes for item id's passed as (eg - id1,id2,id3)
     *
     * @param ids - Item id's passed as a comma separated values (eg - id1,id2,id3)
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getUserLikes(ids: String): Observable<UserLikesResponse>

    /**
     * This method likes an item based on the item id
     *
     * @param itemId - Item id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun likeItem(itemId: Int, callback: Callback<Like>): CancellableTask

    /**
     * This method likes an item based on the item id
     *
     * @param itemId - Item id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun likeItem(itemId: Int): Observable<Like>

    /**
     * This method un likes an item based on the item id
     *
     * @param itemId - Item id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun unLikeItem(itemId: Int, callback: Callback<Like>): CancellableTask

    /**
     * This method un likes an item based on the item id
     *
     * @param itemId - Item id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun unLikeItem(itemId: Int): Observable<Like>
}
