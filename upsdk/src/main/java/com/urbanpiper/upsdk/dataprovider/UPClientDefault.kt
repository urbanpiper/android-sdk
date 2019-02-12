package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.BuildConfig
import com.urbanpiper.upsdk.model.JWTAuthLoginBody
import com.urbanpiper.upsdk.model.JWTRefreshTokenBody
import com.urbanpiper.upsdk.model.networkresponse.*
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private class UPClientDefault(
    private val bizId: String
    , private val apiUsername: String
    , private val apiKey: String
    , private var language: String
) : UPClient {

    // Member variables
    private val generalService: GeneralServiceDefault
    private val storeService: StoreServiceDefault
    private val orderingService: CatalogueServiceDefault
    private val authService: UserServiceDefault

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
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        generalService = GeneralServiceDefault(authToken, bizId, retrofit)
        storeService = StoreServiceDefault(authToken, bizId, retrofit)
        orderingService = CatalogueServiceDefault(authToken, bizId, retrofit)
        authService = UserServiceDefault(authToken, bizId, retrofit)
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

    override fun getBanners(callback: Callback<BannerResponse>): CancellableTask {
        return generalService.getBanners(callback)
    }

    override fun appVersionCheck(
        username: String, version: String, callback: Callback<AppVersionCheckResponse>): CancellableTask {
        return generalService.appVersionCheck(username, version, callback)
    }

    override fun registerDeviceForFCM(fcmRegistrationToken: String, deviceId: String, callback: Callback<Void>): CancellableTask {
        return generalService.registerDeviceForFCM(fcmRegistrationToken, deviceId, callback)
    }

    // -------------------------- STORE SERVICE ----------------------------------

    override fun getNearestStore(latitude: Double, longitude: Double, callback: Callback<StoreLocationResponse>) : CancellableTask{
        return storeService.getNearestStore(latitude, longitude, callback)
    }

    override fun getAllStores(callback: Callback<AllStoresResponse>) : CancellableTask{
        return storeService.getAllStores(callback)
    }

    // --------------------------- ORDERING SERVICE -------------------------------

    override fun getCategories(locationId: Int, callback: Callback<OrderCategoriesResponse>): CancellableTask {
        return orderingService.getCategories(locationId,callback)
    }

    override fun getItems(categoryId: Int, locationId: String, offset: Int, limit: Int, callback: Callback<CartItemResponse>): CancellableTask {
        return orderingService.getItems(categoryId, locationId, offset, limit, callback)
    }

    override fun getFilterAndSortOptions(categoryId: Int, callback: Callback<FilterAndSortOptionsResponse>): CancellableTask {
        return orderingService.getFilterAndSortOptions(categoryId, callback)
    }

    override fun getFilteredItems(categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int, callback: Callback<CartItemResponse>): CancellableTask {
        return orderingService.getFilteredItems(categoryId, locationId, filterBy, offset, limit, callback)
    }

    override fun getSortByItems(categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int, callback: Callback<CartItemResponse>): CancellableTask {
        return orderingService.getSortByItems(categoryId, locationId, sortBy, offset, limit, callback)
    }

    override fun getFeaturedItems(locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask {
        return orderingService.getFeaturedItems(locationId, callback)
    }

    override fun getRecommendedItems(itemId: String, locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask {
        return orderingService.getRecommendedItems(itemId, locationId, callback)
    }

    override fun getItemDetails(itemId: Int, locationId: Int, cacheBuster: Long, callback: Callback<OrderItemResponse>): CancellableTask {
        return orderingService.getItemDetails(itemId, locationId, cacheBuster, callback)
    }

    override fun searchItems(keyword: String, locationId: Int, callback: Callback<OrderItemsSearchResponse>): CancellableTask {
        return orderingService.searchItems(keyword, locationId, callback)
    }

    // ------------------------------- AUTH SERVICE --------------------------------

    override fun login(body: JWTAuthLoginBody, callback: Callback<AuthSuccessResponse>): CancellableTask {
        return authService.login(body, callback)
    }

    override fun refreshToken(body: JWTRefreshTokenBody, callback: Callback<AuthSuccessResponse>): CancellableTask {
        return authService.refreshToken(body, callback)
    }





}