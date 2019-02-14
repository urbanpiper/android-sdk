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
    private val catalogueService: CatalogueServiceDefault
    private val userService: UserServiceDefault
    private val promotionsService: PromotionsServiceDefault

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

    override fun appVersionCheck(username: String, version: String, callback: Callback<AppVersionCheckResponse>): CancellableTask {
        return generalService.appVersionCheck(username, version, callback)
    }

    override fun registerDeviceForFCM(fcmRegistrationToken: String, deviceId: String, callback: Callback<Void>): CancellableTask {
        return generalService.registerDeviceForFCM(fcmRegistrationToken, deviceId, callback)
    }

    override fun getNearestStore(latitude: Double, longitude: Double, callback: Callback<StoreLocationResponse>): CancellableTask {
        return generalService.getNearestStore(latitude, longitude, callback)
    }

    override fun getAllStores(callback: Callback<AllStoresResponse>): CancellableTask {
        return generalService.getAllStores(callback)
    }

    // --------------------------- CATALOGUE SERVICE -------------------------------

    override fun getCategories(locationId: Int, callback: Callback<OrderCategoriesResponse>): CancellableTask {
        return catalogueService.getCategories(locationId, callback)
    }

    override fun getItems(categoryId: Int, locationId: String, offset: Int, limit: Int, callback: Callback<CartItemResponse>): CancellableTask {
        return catalogueService.getItems(categoryId, locationId, offset, limit, callback)
    }

    override fun getFilterAndSortOptions(categoryId: Int, callback: Callback<FilterAndSortOptionsResponse>): CancellableTask {
        return catalogueService.getFilterAndSortOptions(categoryId, callback)
    }

    override fun getFilteredItems(categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int, callback: Callback<CartItemResponse>): CancellableTask {
        return catalogueService.getFilteredItems(categoryId, locationId, filterBy, offset, limit, callback)
    }

    override fun getSortByItems(categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int, callback: Callback<CartItemResponse>): CancellableTask {
        return catalogueService.getSortByItems(categoryId, locationId, sortBy, offset, limit, callback)
    }

    override fun getFeaturedItems(locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask {
        return catalogueService.getFeaturedItems(locationId, callback)
    }

    override fun getRecommendedItems(itemId: String, locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask {
        return catalogueService.getRecommendedItems(itemId, locationId, callback)
    }

    override fun getItemDetails(itemId: Int, locationId: Int, cacheBuster: Long, callback: Callback<OrderItemResponse>): CancellableTask {
        return catalogueService.getItemDetails(itemId, locationId, cacheBuster, callback)
    }

    override fun searchItems(keyword: String, locationId: Int, callback: Callback<OrderItemsSearchResponse>): CancellableTask {
        return catalogueService.searchItems(keyword, locationId, callback)
    }

    // ------------------------------- USER SERVICE --------------------------------

    override fun login(body: JWTAuthLoginBody, callback: Callback<AuthSuccessResponse>): CancellableTask {
        return userService.login(body, callback)
    }

    override fun refreshToken(body: JWTRefreshTokenBody, callback: Callback<AuthSuccessResponse>): CancellableTask {
        return userService.refreshToken(body, callback)
    }

    // ------------------------ PROMOTIONS SERVICE -------------------------------

    override fun getBanners(callback: Callback<BannerResponse>): CancellableTask {
        return promotionsService.getBanners(callback)
    }


}