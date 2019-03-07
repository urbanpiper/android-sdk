package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.BuildConfig
import com.urbanpiper.upsdk.model.JWTAuthLoginBody
import com.urbanpiper.upsdk.model.JWTRefreshTokenBody
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
    override fun checkAppVersion(username: String, version: String, callback: Callback<VersionCheckResponse>): CancellableTask {
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
        return catalogueService.getCategories(locationId,callback)
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
    override fun getCategoryItems(categoryId: Int, locationId: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>): CancellableTask {
        return catalogueService.getCategoryItems(categoryId, locationId, offset, limit, callback)
    }

    /**
     * Get items for a particular category
     */
    override fun getCategoryItems(categoryId: Int, locationId: String, offset: Int, limit: Int): Observable<CategoryItemResponse> {
        return catalogueService.getCategoryItems(categoryId, locationId, offset, limit)
    }

    /**
     * Get filter and sort options for a particular category
     */
    override fun getFilterAndSortOptions(categoryId: Int, callback: Callback<FilterAndSortOptionsResponse>): CancellableTask {
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
    override fun getFilteredItems(categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>): CancellableTask {
        return catalogueService.getFilteredItems(categoryId, locationId, filterBy, offset, limit, callback)
    }

    /**
     * Get filtered items for a particular category
     */
    override fun getFilteredItems(categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int): Observable<CategoryItemResponse> {
        return catalogueService.getFilteredItems(categoryId, locationId, filterBy, offset, limit)
    }

    /**
     * Get sorted items for a particular category
     */
    override fun getSortedItems(categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>): CancellableTask {
        return catalogueService.getSortedItems(categoryId, locationId, sortBy, offset, limit, callback)
    }

    /**
     * Get sorted items for a particular category
     */
    override fun getSortedItems(categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int): Observable<CategoryItemResponse> {
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
    override fun getRelatedItems(itemId: String, locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask {
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
    override fun getItemDetails(itemId: Int, locationId: Int, callback: Callback<ItemDetailsResponse>): CancellableTask {
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
    override fun searchItems(query: String, locationId: Int, callback: Callback<CategorySearchResponse>): CancellableTask {
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

}