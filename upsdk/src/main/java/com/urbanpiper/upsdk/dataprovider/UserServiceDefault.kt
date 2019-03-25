package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.*
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class UserServiceDefault( private val bizId: String, retrofit: Retrofit) : UserService {

    private val userRetrofitService: UserRetrofitService =
        retrofit.create(UserRetrofitService::class.java)

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
     * For login the user needs to provide his/her phone number, along with the password
     * that they had set for their account.
     *
     * @param phone - Phone number of the user
     * @param password - User password
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun login(phone: String, password: String): Observable<AuthSuccessResponse> {
        val body = JWTAuthLoginBody(phone, password)
        val authToken: String = SharedPrefManager.getAuthToken( false)
        val observable = userRetrofitService.login(authToken, body).share()

        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    val response: AuthSuccessResponse = success
                    SharedPrefManager.saveToken(response.token)
                }, { error ->
                })
        )

        return observable
    }

    /**
     * We use JWT tokens for authentication, we need to use this method to get a new token
     * if the current token has completed 80% of it's lifetime
     *
     * @param token - Old token
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * We use JWT tokens for authentication, we need to use this method to get a new token
     * if the current token has completed 80% of it's lifetime
     *
     * @param token - Old token
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun refreshToken(token: String): Observable<AuthSuccessResponse> {
        val body = JWTRefreshTokenBody(token)
        val authToken: String = SharedPrefManager.getAuthToken( false)

        val observable = userRetrofitService.refreshToken(authToken, body).share()
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    val response: AuthSuccessResponse = success
                    SharedPrefManager.saveToken(response.token)
                }, { error ->
                })
        )
        return observable
    }

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
        phone: String, email: String, password: String, name: String, callback: Callback<RegistrationResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            registerUser(phone, email, password, name)
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
     * This method is used to register a new user
     *
     * @param phone - Phone number
     * @param email - Email
     * @param password - Password
     * @param name - Name
     */
    fun registerUser(
        phone: String, email: String, password: String, name: String
    ): Observable<RegistrationResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( false)
        return userRetrofitService.createUser(
            authToken, phone, email, password, name, "app_android", null
        )
    }

    /**
     * This method is used to verify the OTP
     *
     * @param phone - Phone number
     * @param pin - pin
     * @param name - name
     * @param callback - callback to return the result
     */
    fun verifyOTP(
        phone: String, pin: String, name: String, callback: Callback<RegistrationResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            verifyOTP(phone, pin, name)
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
     * This method is used to verify the OTP
     *
     * @param phone - Phone number
     * @param pin - Pin
     * @param name - Name
     */
    fun verifyOTP(phone: String, pin: String, name: String): Observable<RegistrationResponse> {
        val body = VerifyOTPBody(phone, pin, name, "app_android")
        val authToken: String = SharedPrefManager.getAuthToken( false)
        return userRetrofitService.verifyOTP(authToken, body)
    }

    /**
     * This method is used ot resend the OTP
     *
     * @param phone - Phone number
     * @param callback - callback to return the result
     */
    fun resendOTP(phone: String, callback: Callback<RegistrationResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            resendOTP(phone)
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
     * This method is used to resend the OTP
     *
     * @param phone - Phone number
     */
    fun resendOTP(phone: String): Observable<RegistrationResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( false)
        return userRetrofitService.resendOTP(authToken, phone)
    }

    /**
     * Login to the using social auth providers (eg, Facebook, Google)
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
     * Login to the using social auth providers (eg, Facebook, Google)
     *
     * @param email
     * @param provider
     * @param accessToken
     * @param action
     * @param phone
     * @param otp
     */
    fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String, otp: String
    ): Observable<SocialAuthResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( false)
        return userRetrofitService.socialLogin(
            authToken, bizId, email, provider, accessToken, phone, action, otp
        )
    }

    /**
     * Login to the using social auth providers (eg, Facebook, Google)
     *
     * @param email
     * @param provider
     * @param accessToken
     * @param callback
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
     * Login to the using social auth providers (eg, Facebook, Google)
     *
     * @param email
     * @param provider
     * @param accessToken
     */
    override fun socialLogin(email: String, provider: String, accessToken: String): Observable<SocialAuthResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( false)

        val observable = userRetrofitService.socialLogin(authToken, bizId, email, provider, accessToken).share()
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    val response: SocialAuthResponse = success
                    SharedPrefManager.saveToken(response.token)
                }, { error ->
                })
        )
        return observable
    }

    /**
     * Check if phone number is present in the server. It will also send an OTP if the user is present
     * in the server, or you will have to create a new user
     *
     * @param email - Email
     * @param phone - Phone
     * @param provider - Provider
     * @param accessToken - Access Token for google / facebook
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun verifyPhone(
        email: String, phone: String, provider: String, accessToken: String, callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            verifyPhone(email, phone, provider, accessToken)
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
     * Check if phone number is present in the server. It will also send an OTP if the user is present
     * in the server, or you will have to create a new user
     *
     * @param email - Email
     * @param phone - Phone
     * @param provider - Provider
     * @param accessToken - Access Token for google / facebook
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun verifyPhone(
        email: String, phone: String, provider: String, accessToken: String
    ): Observable<SocialAuthResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( false)
        return userRetrofitService.verifyPhone(authToken, bizId, email, phone, provider, accessToken)
    }

    /**
     * Returns the profile data associated with a particular user identified by his/her phone number.
     *
     * @param phone - Phone number
     * @param callback - The result is returned as a callback
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * Returns the profile data associated with a particular user identified by his/her phone number.
     *
     * @param phone - Phone number
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun refreshUserInfo(phone: String): Observable<UserInfoResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.refreshUserInfo(authToken, phone)
    }

    /**
     * Updates the profile data associated with a particular user identified by the phone number.
     *
     * @param phone - Phone number
     * @param body - UpdateUserInfo Object
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * Updates the profile data associated with a particular user identified by the phone number.
     *
     * @param phone - Phone number
     * @param body - UpdateUserInfo Object
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun updateUserInfo(phone: String, body: UpdateUserInfoBody): Observable<UpdateUserInfoResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.updateUserInfo(authToken, phone, body)
    }

    /**
     * Returns the profile data associated with a particular user identified by his/her phone number.
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * Returns the profile data associated with a particular user identified by his/her phone number.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun refreshUserBizInfo(): Observable<UserBizInfoResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.refreshUserBizInfo(authToken, bizId)
    }

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
    override fun changePassword(
        oldPassword: String, newPassword: String, confirmPassword: String, phone: String,
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
    override fun changePassword(
        oldPassword: String,
        newPassword: String,
        confirmPassword: String,
        phone: String
    ): Observable<GenericResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        val body = ChangePasswordBody(bizId, oldPassword, newPassword, confirmPassword, phone)
        return userRetrofitService.changePassword(authToken, body)
    }

    /**
     * This method returns a list of addresses for a given location idm
     * with a field deliverable(true or false) indicating if delivery is possible for that location or not
     *
     * @param locationId - Location id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * This method returns a list of addresses for a given location id
     * with a field deliverable(true or false) indicating if delivery is possible for that location or not
     *
     * @param locationId - Location id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getDeliverableAddresses(locationId: String): Observable<DeliverableAddressResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.getDeliverableAddress(authToken, locationId)
    }

    /**
     * This method adds a new address for the user
     *
     * @param userAddress - UserAddress Object
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * This method adds a new address for the user
     *
     * @param userAddress - UserAddress Object
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun addAddress(userAddress: UserAddress): Observable<UserAddressSaveResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.addAddress(authToken, userAddress)
    }

    /**
     * This method adds a updates an existing address for the user
     *
     * @param userAddress - UserAddress Object
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * This method adds a updates an existing address for the user
     *
     * @param userAddress - UserAddress Object
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun updateAddress(userAddress: UserAddress): Observable<UserAddressSaveResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.updateAddress(authToken, userAddress)
    }

    /**
     * This method deletes an existing address for a user
     *
     * @param addressId - Address id
     * @param callback - Callback
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * This method deletes an existing address for a user
     *
     * @param addressId - Address id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun deleteAddress(addressId: String): Observable<UserAddressSaveResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.deleteAddress(authToken, addressId)
    }

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
    override fun getWalletTransactions(limit: String, offset: String): Observable<TransactionsResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.getWalletTransactions(authToken, limit, offset)
    }

    /**
     * This endpoint returns the list of orders placed by a user in the past. Only the summary data
     * for each order is returned. This should be used when a client needs to display the past orders placed
     * by a user.
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getPastOrders(callback: Callback<OrderHistoryResponse>): CancellableTask {
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
     * This endpoint returns the list of orders placed by a user in the past. Only the summary data
     * for each order is returned. This should be used when a client needs to display the past orders placed
     * by a user.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getPastOrders(): Observable<OrderHistoryResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.getPastOrders(authToken)
    }

    /**
     * Returns details information about an order
     *
     * @param orderId - Order id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * Returns details information about an order
     *
     * @param orderId - Order id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getPastOrderDetails(orderId: Int): Observable<OrderDetailResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.getPastOrderDetails(authToken, orderId)
    }

    /**
     * This method redeems a reward for a user
     *
     * @param rewardId - Id of the reward
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * This method redeems a reward for a user
     *
     * @param rewardId - Id of the reward
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun redeemReward(rewardId: Int): Observable<RedeemRewardResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.redeemReward(authToken, rewardId, "")
    }

    /**
     * This method returns a list of all the notifications that was sent to that user
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getNotifications(callback: Callback<UserBizNotificationsResponse>): CancellableTask {
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
     * This method returns a list of all the notifications that was sent to that user
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getNotifications(): Observable<UserBizNotificationsResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.getNotifications(authToken)
    }

    /**
     * this method submits user feedback
     *
     * @param feedback - feedback object
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * this method submits user feedback
     *
     * @param feedback - feedback object
     *
     * @param feedback
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun submitFeedback(feedback: UserFeedback): Observable<SimpleResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.submitFeedback(authToken, feedback)
    }

    /**
     * Returns a list of likes for item id's passed as (eg - id1,id2,id3)
     *
     * @param ids - Item id's passed as a comma separated values (eg - id1,id2,id3)
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * Returns a list of likes for item id's passed as (eg - id1,id2,id3)
     *
     * @param ids - Item id's passed as a comma separated values (eg - id1,id2,id3)
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getUserLikes(ids: String): Observable<UserLikesResponse> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.getUserLikes(authToken, ids)
    }

    /**
     * This method likes an item based on the item id
     *
     * @param itemId - Item id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * This method likes an item based on the item id
     *
     * @param itemId - Item id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun likeItem(itemId: Int): Observable<Like> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.likeItem(authToken, itemId, "")
    }

    /**
     * This method un likes an item based on the item id
     *
     * @param itemId - Item id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
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
     * This method un likes an item based on the item id
     *
     * @param itemId - Item id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun unLikeItem(itemId: Int): Observable<Like> {
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.unLikeItem(authToken, itemId)
    }

    /**
     * This method generates a password reset token that is sent to the user through
     * SMS and phone
     *
     * @param phone - Phone number
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun sendResetPasswordOTP(phone: String, callback: Callback<GenericResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            sendResetPasswordOTP(phone)
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
     * This method generates a password reset token that is sent to the user through
     * SMS and phone
     *
     * @param phone - Phone number
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun sendResetPasswordOTP(phone: String): Observable<GenericResponse> {
        val body = ForgotPwdGenerateTokenReq(bizId, phone)
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.getResetPasswordToken(authToken, body)
    }

    /**
     * This method reset's the password after the user enter's the password reset token sent
     * through SMS and email
     *
     * The password has to be sent twice so that the server can verify it
     *
     * @param phone - Phone number
     * @param newPassword - New password
     * @param confirmPassword - Confirm same password
     * @param token - Token the user input's
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun resetPassword(
        phone: String, newPassword: String, confirmPassword: String, token: String,
        callback: Callback<GenericResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            resetPassword(phone, newPassword, confirmPassword, token)
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
     * This method reset's the password after the user enter's the password reset token sent
     * through SMS and email
     *
     * The password has to be sent twice so that the server can verify it
     *
     * @param phone - Phone number
     * @param newPassword - New password
     * @param confirmPassword - Confirm same password
     * @param token - Token the user input's
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun resetPassword(
        phone: String, newPassword: String, confirmPassword: String, token: String
    ): Observable<GenericResponse> {
        val body = ForgotPwdGenerateTokenReq(bizId, phone, token, newPassword, confirmPassword)
        val authToken: String = SharedPrefManager.getAuthToken( true)
        return userRetrofitService.resetPassword(authToken, body)
    }

}