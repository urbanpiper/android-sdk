package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.BuildConfig
import com.urbanpiper.upsdk.model.*
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private class UPClientDefault(
    private val bizId: String
    , private val apiUsername: String
    , private val apiKey: String
    , private var language: String
) : UPClient {

    // Member variables
    private val generalService: GeneralService
    private val catalogueService: CatalogueService
    private val userService: UserService
    private val promotionsService: PromotionsService
    private val cartService: CartService

    // Initialization block
    init {
        val authToken = String.format("apikey %s:%s", apiUsername, apiKey)

        val client: OkHttpClient = OkHttpClient().newBuilder()
            .addInterceptor { chain ->
                val original = chain.request()
                val request: Request = original.newBuilder()
                    .addHeader("X-App-Version", BuildConfig.VERSION_NAME)
                    .addHeader("X-BID", bizId)
                    .addHeader("X-App-Src", "android-sdk")
                    .addHeader("X-Use-Lang", language)
                    .method(original.method(), original.body())
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            })
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.urbanpiper.com/")
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        generalService = GeneralServiceDefault(authToken, bizId, retrofit)
        catalogueService = CatalogueServiceDefault(authToken, bizId, retrofit)
        userService = UserServiceDefault(authToken, bizId, retrofit)
        promotionsService = PromotionsServiceDefault(authToken, bizId, retrofit)
        cartService = CartServiceDefault(authToken, bizId, retrofit)
    }
    // ----------------------  BASIC DETAILS ------------------------------------

    override fun getBizId(): String {
        return bizId
    }

    override fun getApiUserName(): String {
        return apiUsername
    }

    override fun getAPIKey(): String {
        return apiKey
    }

    override fun getBizLanguage(): String {
        return language
    }

    override fun changeLanguage(language: String) {
        this.language = language
    }

    // -------------------------- GENERAL SERVICE -------------------------------

    /**
     * App version check
     */
    override fun checkAppVersion(
        username: String,
        version: String,
        callback: Callback<VersionCheckResponse>
    ): CancellableTask {
        return generalService.checkAppVersion(username, version, callback)
    }

    /**
     * App version check
     */
    override fun checkAppVersion(username: String, version: String): Observable<VersionCheckResponse> {
        return generalService.checkAppVersion(username, version)
    }

    /**
     * Register the device for FCM
     *
     * This should return a generic response in the callback
     */
    override fun registerFCMToken(token: String, deviceId: String, callback: Callback<Void>): CancellableTask {
        return generalService.registerFCMToken(token, deviceId, callback)
    }

    /**
     * Register the device for FCM
     *
     * This should return a generic response in the callback
     */
    override fun registerFCMToken(token: String, deviceId: String): Observable<Void> {
        return generalService.registerFCMToken(token, deviceId)
    }

    /**
     * Returns the nearest store based on lat/ lng
     */
    override fun getNearestStore(lat: Double, lng: Double, callback: Callback<StoreReponse>): CancellableTask {
        return generalService.getNearestStore(lat, lng, callback)
    }

    /**
     * Returns the nearest store based on lat/ lng
     */
    override fun getNearestStore(lat: Double, lng: Double): Observable<StoreReponse> {
        return generalService.getNearestStore(lat, lng)
    }

    /**
     * Returns all the stores for the biz
     */
    override fun getAllStores(callback: Callback<StoreListResponse>): CancellableTask {
        return generalService.getAllStores(callback)
    }

    /**
     * Returns all the stores for the biz
     */
    override fun getAllStores(): Observable<StoreListResponse> {
        return generalService.getAllStores()
    }

    // --------------------------- CATALOGUE SERVICE -------------------------------

    /**
     * Get all the categories
     */
    override fun getCategories(locationId: Int, callback: Callback<CategoriesResponse>): CancellableTask {
        return catalogueService.getCategories(locationId, callback)
    }

    /**
     * Get all the categories
     */
    override fun getCategories(locationId: Int): Observable<CategoriesResponse> {
        return catalogueService.getCategories(locationId)
    }

    /**
     * Get items for a particular category
     */
    override fun getCategoryItems(
        categoryId: Int,
        locationId: String,
        offset: Int,
        limit: Int,
        callback: Callback<CategoryItemResponse>
    ): CancellableTask {
        return catalogueService.getCategoryItems(categoryId, locationId, offset, limit, callback)
    }

    /**
     * Get items for a particular category
     */
    override fun getCategoryItems(
        categoryId: Int,
        locationId: String,
        offset: Int,
        limit: Int
    ): Observable<CategoryItemResponse> {
        return catalogueService.getCategoryItems(categoryId, locationId, offset, limit)
    }

    /**
     * Get filter and sort options for a particular category
     */
    override fun getFilterAndSortOptions(
        categoryId: Int,
        callback: Callback<FilterAndSortOptionsResponse>
    ): CancellableTask {
        return catalogueService.getFilterAndSortOptions(categoryId, callback)
    }

    /**
     * Get filter and sort options for a particular category
     */
    override fun getFilterAndSortOptions(categoryId: Int): Observable<FilterAndSortOptionsResponse> {
        return catalogueService.getFilterAndSortOptions(categoryId)
    }

    /**
     * Get filtered items for a particular category
     */
    override fun getFilteredItems(
        categoryId: Int,
        locationId: String,
        filterBy: String,
        offset: Int,
        limit: Int,
        callback: Callback<CategoryItemResponse>
    ): CancellableTask {
        return catalogueService.getFilteredItems(categoryId, locationId, filterBy, offset, limit, callback)
    }

    /**
     * Get filtered items for a particular category
     */
    override fun getFilteredItems(
        categoryId: Int,
        locationId: String,
        filterBy: String,
        offset: Int,
        limit: Int
    ): Observable<CategoryItemResponse> {
        return catalogueService.getFilteredItems(categoryId, locationId, filterBy, offset, limit)
    }

    /**
     * Get sorted items for a particular category
     */
    override fun getSortedItems(
        categoryId: Int,
        locationId: String,
        sortBy: String,
        offset: Int,
        limit: Int,
        callback: Callback<CategoryItemResponse>
    ): CancellableTask {
        return catalogueService.getSortedItems(categoryId, locationId, sortBy, offset, limit, callback)
    }

    /**
     * Get sorted items for a particular category
     */
    override fun getSortedItems(
        categoryId: Int,
        locationId: String,
        sortBy: String,
        offset: Int,
        limit: Int
    ): Observable<CategoryItemResponse> {
        return catalogueService.getSortedItems(categoryId, locationId, sortBy, offset, limit)
    }

    /**
     * Get recommended items
     */
    override fun getRecommendedItems(locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask {
        return catalogueService.getRecommendedItems(locationId, callback)
    }

    /**
     * Get recommended items
     */
    override fun getRecommendedItems(locationId: Int): Observable<RecommendedItemResponse> {
        return catalogueService.getRecommendedItems(locationId)
    }

    /**
     * Get Related items
     */
    override fun getRelatedItems(
        itemId: String,
        locationId: Int,
        callback: Callback<RecommendedItemResponse>
    ): CancellableTask {
        return catalogueService.getRelatedItems(itemId, locationId, callback)
    }

    /**
     * Get Related items
     */
    override fun getRelatedItems(itemId: String, locationId: Int): Observable<RecommendedItemResponse> {
        return catalogueService.getRelatedItems(itemId, locationId)
    }

    /**
     * Get Item Details
     */
    override fun getItemDetails(
        itemId: Int,
        locationId: Int,
        callback: Callback<ItemDetailsResponse>
    ): CancellableTask {
        return catalogueService.getItemDetails(itemId, locationId, callback)
    }

    /**
     * Get Item Details
     */
    override fun getItemDetails(itemId: Int, locationId: Int): Observable<ItemDetailsResponse> {
        return catalogueService.getItemDetails(itemId, locationId)
    }

    /**
     * Search for items
     */
    override fun searchItems(
        query: String,
        locationId: Int,
        callback: Callback<CategorySearchResponse>
    ): CancellableTask {
        return catalogueService.searchItems(query, locationId, callback)
    }

    /**
     * Search for items
     */
    override fun searchItems(query: String, locationId: Int): Observable<CategorySearchResponse> {
        return catalogueService.searchItems(query, locationId)
    }

    // ------------------------------- USER SERVICE --------------------------------

    /**
     *  Login - The result is returned in a callback
     */
    override fun login(phone: String, password: String, callback: Callback<AuthSuccessResponse>): CancellableTask {
        return userService.login(phone, password, callback)
    }

    /**
     *  Login - The result is returned as an Observable
     */
    override fun login(phone: String, password: String): Observable<AuthSuccessResponse> {
        return userService.login(phone, password)
    }

    /**
     * Refresh Token - the result is returned as a callback
     */
    override fun refreshToken(token: String, callback: Callback<AuthSuccessResponse>): CancellableTask {
        return userService.refreshToken(token, callback)
    }

    /**
     * refresh token - The result is returned as an observable
     */
    override fun refreshToken(token: String): Observable<AuthSuccessResponse> {
        return userService.refreshToken(token)
    }

    /**
     * Social login - the result is returned as a callback
     *
     */
    override fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String, otp: String,
        callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        return userService.socialLoginOTP(email, provider, accessToken, action, phone, otp, callback)
    }

    /**
     * Social login - The result is returned as an observable
     *
     */
    override fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String, otp: String
    ): Observable<SocialAuthResponse> {
        return userService.socialLoginOTP(email, provider, accessToken, action, phone, otp)
    }

    /**
     *  Refresh user info - The result is returned as a callback
     */
    override fun refreshUserInfo(phone: String, callback: Callback<UserInfoResponse>): CancellableTask {
        return userService.refreshUserInfo(phone, callback)
    }

    /**
     *  Refresh user info - The result is returned as a Observable
     */
    override fun refreshUserInfo(phone: String): Observable<UserInfoResponse> {
        return userService.refreshUserInfo(phone)
    }

    /**
     * Social login - the result is returned as a callback
     */
    override fun socialLogin(
        email: String,
        provider: String,
        accessToken: String,
        callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        return userService.socialLogin(email, provider, accessToken, callback)
    }

    /**
     * Social login - The result is returned as an observable
     */
    override fun socialLogin(email: String, provider: String, accessToken: String): Observable<SocialAuthResponse> {
        return userService.socialLogin(email, provider, accessToken)
    }

    /**
     * Update user info - The result is returned as a callback
     */
    override fun updateUserInfo(
        phone: String,
        body: UpdateUserInfoBody,
        callback: Callback<UpdateUserInfoResponse>
    ): CancellableTask {
        return userService.updateUserInfo(phone, body, callback)
    }

    /**
     * Update user info - the result is returned as a observable
     */
    override fun updateUserInfo(phone: String, body: UpdateUserInfoBody): Observable<UpdateUserInfoResponse> {
        return userService.updateUserInfo(phone, body)
    }

    /**
     * Refresh User Biz info - The result is returned as a callback
     */
    override fun refreshUserBizInfo(callback: Callback<UserBizInfoResponse>): CancellableTask {
        return userService.refreshUserBizInfo(callback)
    }

    /**
     * Refresh User Biz info - the result is returned as a observable
     */
    override fun refreshUserBizInfo(): Observable<UserBizInfoResponse> {
        return userService.refreshUserBizInfo()
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
        return userService.changePassword(oldPassword, newPassword, confirmPassword, phone, callback)
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
        return userService.changePassword(oldPassword, newPassword, confirmPassword, phone)
    }

    /**
     * get Deliverable address - The result is returned as a callback
     */
    override fun getDeliverableAddresses(
        locationId: String,
        callback: Callback<DeliverableAddressResponse>
    ): CancellableTask {
        return userService.getDeliverableAddresses(locationId, callback)
    }

    /**
     * get Deliverable address - The result is returned as a observable
     */
    override fun getDeliverableAddresses(locationId: String): Observable<DeliverableAddressResponse> {
        return userService.getDeliverableAddresses(locationId)
    }

    /**
     * Add an address - The result is a callback
     */
    override fun addAddress(userAddress: UserAddress, callback: Callback<UserAddressSaveResponse>): CancellableTask {
        return userService.addAddress(userAddress, callback)
    }

    /**
     * add an address
     */
    override fun addAddress(userAddress: UserAddress): Observable<UserAddressSaveResponse> {
        return userService.addAddress(userAddress)
    }

    /**
     * Update an address
     */
    override fun updateAddress(userAddress: UserAddress, callback: Callback<UserAddressSaveResponse>): CancellableTask {
        return userService.updateAddress(userAddress, callback)
    }

    /**
     * Update an existing address
     */
    override fun updateAddress(userAddress: UserAddress): Observable<UserAddressSaveResponse> {
        return userService.updateAddress(userAddress)
    }

    /**
     * Delete an existing address
     */
    override fun deleteAddress(addressId: String, callback: Callback<UserAddressSaveResponse>): CancellableTask {
        return userService.deleteAddress(addressId, callback)
    }

    /**
     * Delete an existing address
     */
    override fun deleteAddress(addressId: String): Observable<UserAddressSaveResponse> {
        return userService.deleteAddress(addressId)
    }

    /**
     *  Returns wallet transaction's of the user
     */
    override fun getWalletTransactions(
        limit: String,
        offset: String,
        callback: Callback<TransactionsResponse>
    ): CancellableTask {
        return userService.getWalletTransactions(limit, offset, callback)
    }

    /**
     *  Returns wallet transaction's of the user
     */
    override fun getWalletTransactions(limit: String, offset: String): Observable<TransactionsResponse> {
        return userService.getWalletTransactions(limit, offset)
    }

    /**
     * Fetches the summary data for orders placed in the past by a
     * user.
     */
    override fun getPastOrders(callback: Callback<OrderHistoryV2Response>): CancellableTask {
        return userService.getPastOrders(callback)
    }

    /**
     * Fetches the summary data for orders placed in the past by a
     * user.
     */
    override fun getPastOrders(): Observable<OrderHistoryV2Response> {
        return userService.getPastOrders()
    }

    /**
     * Fetches the summary data for orders placed in the past by a
     * user
     */
    override fun getPastOrderDetails(orderId: Int, callback: Callback<OrderDetailResponse>): CancellableTask {
        return userService.getPastOrderDetails(orderId, callback)
    }

    /**
     * Fetches the summary data for orders placed in the past by a
     * user
     */
    override fun getPastOrderDetails(orderId: Int): Observable<OrderDetailResponse> {
        return userService.getPastOrderDetails(orderId)
    }

    /**
     * Redeem a reward
     */
    override fun redeemReward(rewardId: Int, callback: Callback<RedeemRewardResponse>): CancellableTask {
        return userService.redeemReward(rewardId, callback)
    }

    /**
     * Redeem a reward
     */
    override fun redeemReward(rewardId: Int): Observable<RedeemRewardResponse> {
        return userService.redeemReward(rewardId)
    }

    /**
     *  Retrieves the list of notifications available for
     * the user.
     */
    override fun getNotifications(callback: Callback<UserbizNotificationsResponse>): CancellableTask {
        return userService.getNotifications(callback)
    }

    /**
     *  Retrieves the list of notifications available for
     * the user.
     */
    override fun getNotifications(): Observable<UserbizNotificationsResponse> {
        return userService.getNotifications()
    }

    /**
     * For saving the feedback associated with an order.
     */
    override fun submitFeedback(feedback: UserFeedback, callback: Callback<SimpleResponse>): CancellableTask {
        return userService.submitFeedback(feedback, callback)
    }

    /**
     * For saving the feedback associated with an order.
     */
    override fun submitFeedback(feedback: UserFeedback): Observable<SimpleResponse> {
        return userService.submitFeedback(feedback)
    }

    /**
     * For getting list of likes
     */
    override fun getUserLikes(ids: String, callback: Callback<UserLikesResponse>): CancellableTask {
        return userService.getUserLikes(ids, callback)
    }

    /**
     * For getting list of likes
     */
    override fun getUserLikes(ids: String): Observable<UserLikesResponse> {
        return userService.getUserLikes(ids)
    }

    /**
     * like item
     */
    override fun likeItem(itemId: Int, callback: Callback<Like>): CancellableTask {
        return userService.likeItem(itemId, callback)
    }

    /**
     * like item
     */
    override fun likeItem(itemId: Int): Observable<Like> {
        return userService.likeItem(itemId)
    }

    /**
     * unlike item
     */
    override fun unLikeItem(itemId: Int, callback: Callback<Like>): CancellableTask {
        return userService.unLikeItem(itemId, callback)
    }

    /**
     * unlike item
     */
    override fun unLikeItem(itemId: Int): Observable<Like> {
        return userService.unLikeItem(itemId)
    }


    // ------------------------ PROMOTIONS SERVICE -------------------------------

    /**
     *
     */
    override fun getBanners(callback: Callback<BannerResponse>): CancellableTask {
        return promotionsService.getBanners(callback)
    }

    /**
     * Returns banners from the server using an Observable
     */
    override fun getBanners(): Observable<BannerResponse> {
        return promotionsService.getBanners()
    }

    /**
     *
     */
    override fun getOffers(callback: Callback<OffersResponse>): CancellableTask {
        return promotionsService.getOffers(callback)
    }

    /**
     * Returns offers from the server using an Observable
     */
    override fun getOffers(): Observable<OffersResponse> {
        return promotionsService.getOffers()
    }

    /**
     *
     */
    override fun getRewards(callback: Callback<RewardsResponse>): CancellableTask {
        return promotionsService.getRewards(callback)
    }

    /**
     * Returns rewards from the server using on observable
     */
    override fun getRewards(): Observable<RewardsResponse> {
        return promotionsService.getRewards()
    }
    // ------------------------ CART SERVICE -------------------------------

    /**
     * re-order api
     */
    override fun reOrder(
        orderId: String,
        locationId: String,
        lat: String,
        lng: String,
        callback: Callback<ReOrderResponse>
    ): CancellableTask {
        return cartService.reOrder(orderId, locationId, lat, lng, callback)
    }

    /**
     * re-order api
     */
    override fun reOrder(orderId: String, locationId: String, lat: String, lng: String): Observable<ReOrderResponse> {
        return cartService.reOrder(orderId, locationId, lat, lng)
    }

    /**
     * Get the recommended items from the server. The items returned are based on a particular item
     * in details or checkout page.
     */
    override fun getCartRelatedItems(
        itemIds: String,
        locationId: Int,
        callback: Callback<RecommendedItemResponse>
    ): CancellableTask {
        return cartService.getCartRelatedItems(itemIds, locationId, callback)
    }

    /**
     * Get the recommended items from the server. The items returned are based on a particular item
     * in details or checkout page.
     */
    override fun getCartRelatedItems(itemIds: String, locationId: Int): Observable<RecommendedItemResponse> {
        return cartService.getCartRelatedItems(itemIds, locationId)
    }

    /**
     * Sends the order details to the server for validation.
     */
    override fun validateCart(order: Order, callback: Callback<PreProcessOrderResponse>): CancellableTask {
        return cartService.validateCart(order, callback)
    }

    /**
     * Sends the order details to the server for validation.
     */
    override fun validateCart(order: Order): Observable<PreProcessOrderResponse> {
        return cartService.validateCart(order)
    }

    /**
     * Advanced version of coupon validation - takes in the complete
     * order data as request body.
     */
    override fun validateCoupon(
        couponCode: String,
        body: ValidateCouponBody,
        callback: Callback<OrderValidateCouponResponse>
    ): CancellableTask {
        return cartService.validateCoupon(couponCode, body, callback)
    }

    /**
     * Advanced version of coupon validation - takes in the complete
     * order data as request body.
     */
    override fun validateCoupon(couponCode: String, body: ValidateCouponBody): Observable<OrderValidateCouponResponse> {
        return cartService.validateCoupon(couponCode, body)
    }

    /**
     * Initiates a payment for the particular biz's store. This is useful if the biz is
     * using a franchisee model.
     *
     */
    override fun initPayment(
        storeId: Int,
        amount: Int,
        purpose: String,
        redirectUrl: String,
        paytm: String,
        simpl: String,
        callback: Callback<PaymentInitResponse>
    ): CancellableTask {
        return cartService.initPayment(storeId, amount, purpose, redirectUrl, paytm, simpl, callback)
    }

    /**
     * Initiates a payment for the particular biz's store. This is useful if the biz is
     * using a franchisee model.
     *
     */
    override fun initPayment(
        storeId: Int, amount: Int, purpose: String, redirectUrl: String, paytm: String, simpl: String
    ): Observable<PaymentInitResponse> {
        return cartService.initPayment(storeId, amount, purpose, redirectUrl, paytm, simpl)
    }

    /**
     * Sends the order details to the server for persistence.
     */
    override fun placeOrder(body: Order, callback: Callback<OrderSaveResponse>): CancellableTask {
        return cartService.placeOrder(body, callback)
    }

    /**
     * Sends the order details to the server for persistence.
     */
    override fun placeOrder(body: Order): Observable<OrderSaveResponse> {
        return cartService.placeOrder(body)
    }

    /**
     * Marks the completion of a transaction.
     *
     */
    override fun verifyPayment(
        transactionId: String,
        gwTxnId: String,
        failed: Int,
        callback: Callback<PaymentCallbackResponse>
    ): CancellableTask {
        return cartService.verifyPayment(transactionId, gwTxnId, failed, callback)
    }

    /**
     * Marks the completion of a transaction.
     *
     */
    override fun verifyPayment(
        transactionId: String,
        gwTxnId: String,
        failed: Int
    ): Observable<PaymentCallbackResponse> {
        return cartService.verifyPayment(transactionId, gwTxnId, failed)
    }

    /**
     * Returns an instance of the cart
     */
    override fun getCartInstance(): Cart {
        return cartService.getCartInstance()
    }
}