package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.ChangePasswordBody
import com.urbanpiper.upsdk.model.JWTAuthLoginBody
import com.urbanpiper.upsdk.model.JWTRefreshTokenBody
import com.urbanpiper.upsdk.model.UpdateUserInfoBody
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class UserServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) : UserService {

    private val userRetrofitService: UserRetrofitService =
        retrofit.create(UserRetrofitService::class.java)

    /**
     *  Login - The result is returned in a callback
     */
    override fun login(phone: String, password: String, callback: Callback<AuthSuccessResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            login(phone, password)
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

    /**
     *  Login - The result is returned as an Observable
     */
    override fun login(phone: String, password: String): Observable<AuthSuccessResponse> {
        val body = JWTAuthLoginBody(phone, password)
        return userRetrofitService.login(authToken, body)
    }

    /**
     * Refresh Token - the result is returned as a callback
     */
    override fun refreshToken(token: String, callback: Callback<AuthSuccessResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            refreshToken(token)
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

    /**
     * refresh token - The result is returned as an observable
     */
    override fun refreshToken(token: String): Observable<AuthSuccessResponse> {
        val body = JWTRefreshTokenBody(token)
        return userRetrofitService.refreshToken(authToken, body)
    }

    /**
     * Social login - the result is returned as a callback
     *
     */
    override fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String, otp: String,
        callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            socialLoginOTP(email, provider, accessToken, phone, action, otp)
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

    /**
     * Social login - The result is returned as an observable
     *
     */
    override fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String, otp: String
    ): Observable<SocialAuthResponse> {
        return userRetrofitService.socialLogin(
            authToken, bizId, email, provider, accessToken, phone, action, otp
        )
    }


    /**
     *  Refresh user info - The result is returned as a callback
     */
    override fun refreshUserInfo(phone: String, callback: Callback<UserInfoResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            refreshUserInfo(phone)
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

    /**
     *  Refresh user info - The result is returned as a Observable
     */
    override fun refreshUserInfo(phone: String): Observable<UserInfoResponse> {
        return userRetrofitService.refreshUserInfo(authToken, phone)
    }


    /**
     * Social login - the result is returned as a callback
     */
    override fun socialLogin(
        email: String, provider: String, accessToken: String, callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            socialLogin(email, provider, accessToken)
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

    /**
     * Social login - The result is returned as an observable
     */
    override fun socialLogin(email: String, provider: String, accessToken: String): Observable<SocialAuthResponse> {
        return userRetrofitService.socialLogin(authToken, bizId, email, provider, accessToken)
    }


    /**
     * Update user info - The result is returned as a callback
     */
    override fun updateUserInfo(
        phone: String,
        body: UpdateUserInfoBody,
        callback: Callback<UpdateUserInfoResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            updateUserInfo(phone, body)
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

    /**
     * Update user info - the result is returned as a observable
     */
    override fun updateUserInfo(phone: String, body: UpdateUserInfoBody): Observable<UpdateUserInfoResponse> {
        return userRetrofitService.updateUserInfo(authToken, phone, body)
    }

    /**
     * Refresh User Biz info - The result is returned as a callback
     */
    override fun refreshUserBizInfo(callback: Callback<UserBizInfoResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            refreshUserBizInfo()
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

    /**
     * Refresh User Biz info - the result is returned as a observable
     */
    override fun refreshUserBizInfo(): Observable<UserBizInfoResponse> {
        return userRetrofitService.refreshUserBizInfo(authToken, bizId)
    }

    /**
     * change the password - The result is returned as a callback
     */
    override fun changePassword(
        oldPassword: String,
        newPassword: String,
        confirmPassword: String,
        phone: String,
        callback: Callback<GenericResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            changePassword(oldPassword, newPassword, confirmPassword, phone)
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

    /**
     * change the password - The result tis returned as an Observable
     */
    override fun changePassword(
        oldPassword: String,
        newPassword: String,
        confirmPassword: String,
        phone: String
    ): Observable<GenericResponse> {

        val body = ChangePasswordBody(bizId, oldPassword, newPassword, confirmPassword, phone)
        return userRetrofitService.changePassword(authToken, body)
    }

    /**
     * get Deliverable address - The result is returned as a callback
     */
    override fun getDeliverableAddresses(
        locationId: String,
        callback: Callback<DeliverableAddressResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getDeliverableAddresses(locationId)
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

    /**
     * get Deliverable address - The result is returned as a observable
     */
    override fun getDeliverableAddresses(locationId: String): Observable<DeliverableAddressResponse> {
        return userRetrofitService.getDeliverableAddress(authToken, locationId)
    }

    /**
     * Add an address - The result is a callback
     */
    override fun addAddress(userAddress: UserAddress, callback: Callback<UserAddressSaveResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            addAddress(userAddress)
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

    /**
     * add an address
     */
    override fun addAddress(userAddress: UserAddress): Observable<UserAddressSaveResponse> {
        return userRetrofitService.addAddress(authToken, userAddress)
    }

    /**
     * Update an address
     */
    override fun updateAddress(userAddress: UserAddress, callback: Callback<UserAddressSaveResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            updateAddress(userAddress)
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

    /**
     * Update an existing address
     */
    override fun updateAddress(userAddress: UserAddress): Observable<UserAddressSaveResponse> {
        return userRetrofitService.updateAddress(authToken, userAddress)
    }

    /**
     * Delete an existing address
     */
    override fun deleteAddress(addressId: String, callback: Callback<UserAddressSaveResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            deleteAddress(addressId)
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

    /**
     * Delete an existing address
     */
    override fun deleteAddress(addressId: String): Observable<UserAddressSaveResponse> {
        return userRetrofitService.deleteAddress(authToken, addressId)
    }

    /**
     *  Returns wallet transaction's of the user
     */
    override fun getWalletTransactions(
        limit: String,
        offset: String,
        callback: Callback<TransactionsResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getWalletTransactions(limit, offset)
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

    /**
     *  Returns wallet transaction's of the user
     */
    override fun getWalletTransactions(limit: String, offset: String): Observable<TransactionsResponse> {
        return userRetrofitService.getWalletTransactions(authToken, limit, offset)
    }

    /**
     * Fetches the summary data for orders placed in the past by a
     * user.
     */
    override fun getPastOrders(callback: Callback<OrderHistoryV2Response>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getPastOrders()
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

    /**
     * Fetches the summary data for orders placed in the past by a
     * user.
     */
    override fun getPastOrders(): Observable<OrderHistoryV2Response> {
        return userRetrofitService.getPastOrders(authToken)
    }

    /**
     * Fetches the summary data for orders placed in the past by a
     * user
     */
    override fun getPastOrderDetails(orderId: Int, callback: Callback<OrderDetailResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getPastOrderDetails(orderId)
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

    /**
     * Fetches the summary data for orders placed in the past by a
     * user
     */
    override fun getPastOrderDetails(orderId: Int): Observable<OrderDetailResponse> {
        return userRetrofitService.getPastOrderDetails(authToken, orderId)
    }

    /**
     * Redeem a reward
     */
    override fun redeemReward(rewardId: Int, callback: Callback<RedeemRewardResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            redeemReward(rewardId)
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

    /**
     * Redeem a reward
     */
    override fun redeemReward(rewardId: Int): Observable<RedeemRewardResponse> {
        return userRetrofitService.redeemReward(authToken, rewardId, "")
    }

    /**
     *  Retrieves the list of notifications available for
     * the user.
     */
    override fun getNotifications(callback: Callback<UserbizNotificationsResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getNotifications()
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

    /**
     *  Retrieves the list of notifications available for
     * the user.
     */
    override fun getNotifications(): Observable<UserbizNotificationsResponse> {
        return userRetrofitService.getNotifications(authToken)
    }

    /**
     * For saving the feedback associated with an order.
     */
    override fun submitFeedback(feedback: UserFeedback, callback: Callback<SimpleResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            submitFeedback(feedback)
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

    /**
     * For saving the feedback associated with an order.
     */
    override fun submitFeedback(feedback: UserFeedback): Observable<SimpleResponse> {
        return userRetrofitService.submitFeedback(authToken, feedback)
    }

    /**
     * For getting list of likes
     */
    override fun getUserLikes(ids: String, callback: Callback<UserLikesResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getUserLikes(ids)
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

    /**
     * For getting list of likes
     */
    override fun getUserLikes(ids: String): Observable<UserLikesResponse> {
        return userRetrofitService.getUserLikes(authToken, ids)
    }

    /**
     * like item
     */
    override fun likeItem(itemId: Int, callback: Callback<Like>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            likeItem(itemId)
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

    /**
     * like item
     */
    override fun likeItem(itemId: Int): Observable<Like> {
        return userRetrofitService.likeItem(authToken, itemId, "")
    }

    /**
     * unlike item
     */
    override fun unLikeItem(itemId: Int, callback: Callback<Like>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            unLikeItem(itemId)
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

    /**
     * unlike item
     */
    override fun unLikeItem(itemId: Int): Observable<Like> {
        return userRetrofitService.unLikeItem(authToken, itemId)
    }


}