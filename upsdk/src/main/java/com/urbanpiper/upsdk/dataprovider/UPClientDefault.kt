package com.urbanpiper.upsdk.dataprovider

import android.content.Context
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

/**
 * All methods for the UPSDK are available through
 * this class.
 *
 * This class is a facade
 *
 * @property bizId - Business id of the merchant
 * @property apiUsername - API username of the merchant
 * @property apiKey -  API key of the merchant
 * @property language - The default language of the merchant
 * @param context - Context is used to store data in shared preferences
 * @param callback - Callback to return the result
 */
class UPClientDefault(
    private val bizId: String
    , private val apiUsername: String
    , private val apiKey: String
    , private var language: String
    , context: Context
    , callback: Callback<UserBizInfoResponse>
) : UPClient {

    // Member variables
    private val generalServiceDefault: GeneralServiceDefault
    private val catalogueServiceDefault: CatalogueServiceDefault
    private val userServiceDefault: UserServiceDefault
    private val promotionsServiceDefault: PromotionsServiceDefault
    private val cartServiceDefault: CartServiceDefault

    // Initialization block
    init {
//        val authToken = String.format("apikey %s:%s", apiUsername, apiKey)

        val sp = context.getSharedPreferences(Utils().spSessionDetails, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(Utils().spAPIUsername, apiUsername)
        editor.putString(Utils().spAPIKey, apiKey)
        editor.apply()

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

        generalServiceDefault = GeneralServiceDefault(context, bizId, retrofit)
        catalogueServiceDefault = CatalogueServiceDefault(context, bizId, retrofit)
        userServiceDefault = UserServiceDefault(context, bizId, retrofit)
        promotionsServiceDefault = PromotionsServiceDefault(context, bizId, retrofit)
        cartServiceDefault = CartServiceDefault(context, bizId, retrofit)

        // Refreshing user biz info on init
        refreshUserBizInfo(callback)
    }
    // ----------------------  BASIC DETAILS ------------------------------------

    /**
     * Returns biz id
     *
     */
    override fun getBizId(): String {
        return bizId
    }

    /**
     * Returns api username
     *
     */
    override fun getApiUserName(): String {
        return apiUsername
    }

    /**
     * Returns api key
     *
     */
    override fun getAPIKey(): String {
        return apiKey
    }

    /**
     * Returns current language being passed to the SDK
     *
     */
    override fun getBizLanguage(): String {
        return language
    }

    /**
     * This method is used to change the language of the response being passed to the SDK
     *
     * @param language
     */
    override fun changeLanguage(language: String) {
        this.language = language
    }

    // -------------------------- GENERAL SERVICE -------------------------------


    /**
     * returns the latest version of the android app as configured on the server
     *
     * This can be used to force update the application. The response has a field that shows if force update
     * is required. This method should be called when the app is opened and after the user sign's in.
     *
     * @param username - username of the user
     * @param version - version of the application
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun checkAppVersion(
        username: String, version: String, callback: Callback<VersionCheckResponse>
    ): CancellableTask {
        return generalServiceDefault.checkAppVersion(username, version, callback)
    }

    /**
     * returns the latest version of the android app as configured on the server
     *
     * This can be used to force update the application. The response has a field that shows if force update
     * is required. This method should be called when the app is opened and after the user sign's in.
     *
     * @param username - username of the user
     * @param version - version of the application
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun checkAppVersion(username: String, version: String): Observable<VersionCheckResponse> {
        return generalServiceDefault.checkAppVersion(username, version)
    }

    /**
     * Register the device for FCM
     *
     * This can be used to force update the application. The response has a field that shows if force update
     * is required. This method should be called when the app is opened and after the user sign's in.
     *
     * TODO - This should return a generic response in the callback
     *
     * @param token - FCM registration token
     * @param deviceId - The unique id of the device
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun registerFCMToken(token: String, deviceId: String, callback: Callback<Void>): CancellableTask {
        return generalServiceDefault.registerFCMToken(token, deviceId, callback)
    }

    /**
     * Register the device for FCM
     *
     * This method registers a device to receive FCM messages, This should be called when the app
     * is launched and after the user sign's in to the app
     *
     * TODO - This should return a generic response in the callback
     *
     * @param token - FCM registration token
     * @param deviceId - The unique id of the device
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun registerFCMToken(token: String, deviceId: String): Observable<Void> {
        return generalServiceDefault.registerFCMToken(token, deviceId)
    }

    /**
     * Returns the nearest store based on lat/ lng
     *
     * This endpoint helps determine the nearest store from which an order can be delivered.
     * It expects the latitude/longitude information of the location to be delivered to.
     * Along with the store information, this endpoint also returns the biz related information,
     * which can be cached for later use.
     *
     * @param lat - User's latitude
     * @param lng - User's longitude
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getNearestStore(lat: Double, lng: Double, callback: Callback<StoreReponse>): CancellableTask {
        return generalServiceDefault.getNearestStore(lat, lng, callback)
    }

    /**
     * Returns the nearest store based on lat/ lng
     *
     * This endpoint helps determine the nearest store from which an order can be delivered.
     * It expects the latitude/longitude information of the location to be delivered to.
     * Along with the store information, this endpoint also returns the biz related information,
     * which can be cached for later use.
     *
     * @param lat - User's latitude
     * @param lng - User's longitude
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getNearestStore(lat: Double, lng: Double): Observable<StoreReponse> {
        return generalServiceDefault.getNearestStore(lat, lng)
    }

    /**
     * Returns all the stores for the business
     *
     * This method returns all the stores configured for a business.
     *
     * @param callback - Callback to receive the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getAllStores(callback: Callback<StoreListResponse>): CancellableTask {
        return generalServiceDefault.getAllStores(callback)
    }

    /**
     * Returns all the stores for the business
     *
     * This method returns all the stores configured for a business.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getAllStores(): Observable<StoreListResponse> {
        return generalServiceDefault.getAllStores()
    }

    // --------------------------- CATALOGUE SERVICE -------------------------------

    /**
     * returns a list of active categories of items from which an order can be placed
     *
     * This method returns the list of active categories of items from which an order can be placed.
     *
     * @param locationId - Location id is returned from the store
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getCategories(locationId: Int, callback: Callback<CategoriesResponse>): CancellableTask {
        return catalogueServiceDefault.getCategories(locationId, callback)
    }

    /**
     * returns a list of active categories of items from which an order can be placed
     *
     * This method returns the list of active categories of items from which an order can be placed.
     *
     * @param locationId - Location id is returned from the store
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getCategories(locationId: Int): Observable<CategoriesResponse> {
        return catalogueServiceDefault.getCategories(locationId)
    }

    /**
     * returns a list of active items for a category from which an order can be placed
     *
     * This endpoint returns the list of active items belonging to a particular category.
     * This endpoint can find use in scenarios:
     * When the entire menu for a restaurant is to be displayed.
     * When the location specific list of items need to be shown for accepting an order.
     * In this case, the location_id parameter needs to be passed-in.
     * This is so because the availability for each of the items need to be determined so that customers
     * don’t place an order for items which might be out of stock.
     *
     * @param categoryId - Category ID
     * @param locationId - Location ID
     * @param offset - offset
     * @param limit - limit
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getCategoryItems(
        categoryId: Int, locationId: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>
    ): CancellableTask {
        return catalogueServiceDefault.getCategoryItems(categoryId, locationId, offset, limit, callback)
    }

    /**
     * returns a list of active items for a category from which an order can be placed
     *
     * This endpoint returns the list of active items belonging to a particular category.
     * This endpoint can find use in scenarios:
     * When the entire menu for a restaurant is to be displayed.
     * When the location specific list of items need to be shown for accepting an order.
     * In this case, the location_id parameter needs to be passed-in.
     * This is so because the availability for each of the items need to be determined so that customers
     * don’t place an order for items which might be out of stock.
     *
     * @param categoryId - Category ID
     * @param locationId - Location ID
     * @param offset - offset
     * @param limit - limit
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getCategoryItems(
        categoryId: Int, locationId: String, offset: Int, limit: Int
    ): Observable<CategoryItemResponse> {
        return catalogueServiceDefault.getCategoryItems(categoryId, locationId, offset, limit)
    }

    /**
     * This endpoint handles requests to get available filter and sort options for a category.
     *
     * @param categoryId - Category Id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getFilterAndSortOptions(
        categoryId: Int,
        callback: Callback<FilterAndSortOptionsResponse>
    ): CancellableTask {
        return catalogueServiceDefault.getFilterAndSortOptions(categoryId, callback)
    }

    /**
     * This endpoint handles requests to get available filter and sort options for a category.
     *
     * @param categoryId - Category Id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getFilterAndSortOptions(categoryId: Int): Observable<FilterAndSortOptionsResponse> {
        return catalogueServiceDefault.getFilterAndSortOptions(categoryId)
    }

    /**
     * returns a list of active items filtered based on the filters passed
     *
     * This method returns a list of active items filtered based on filters received
     * from the getFilterAndSortOptions method for a category from which an order can be placed.
     * Multiple filters can be sent as comma separated values (eg - filter1,filter2,filter3)
     *
     * @param categoryId - Category Id
     * @param locationId - Location Id
     * @param filterBy - Filter received from getFilterAndSortOptions methods
     * @param offset - offset
     * @param limit - limit
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getFilteredItems(
        categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int,
        callback: Callback<CategoryItemResponse>
    ): CancellableTask {
        return catalogueServiceDefault.getFilteredItems(categoryId, locationId, filterBy, offset, limit, callback)
    }

    /**
     * returns a list of active items filtered based on the filters passed
     *
     * This method returns a list of active items filtered based on filters received
     * from the getFilterAndSortOptions method for a category from which an order can be placed.
     * Multiple filters can be sent as comma separated values (eg - filter1,filter2,filter3)
     *
     * @param categoryId - Category Id
     * @param locationId - Location Id
     * @param filterBy - Filter received from getFilterAndSortOptions methods
     * @param offset - offset
     * @param limit - limit
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getFilteredItems(
        categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int
    ): Observable<CategoryItemResponse> {
        return catalogueServiceDefault.getFilteredItems(categoryId, locationId, filterBy, offset, limit)
    }

    /**
     * returns a list of active items sorted based on the sort option passed
     *
     * returns a list of active items sorted based on the sort option received
     * from the getFilterAndSortOptions method for a category from which an order can be placed.
     * Only a single sort option can be passed.
     *
     * @param categoryId - Category Id
     * @param locationId - Location Id
     * @param sortBy - Sort option
     * @param offset - offset
     * @param limit - limit
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getSortedItems(
        categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int,
        callback: Callback<CategoryItemResponse>
    ): CancellableTask {
        return catalogueServiceDefault.getSortedItems(categoryId, locationId, sortBy, offset, limit, callback)
    }

    /**
     * returns a list of active items sorted based on the sort option passed
     *
     * returns a list of active items sorted based on the sort option received
     * from the getFilterAndSortOptions method for a category from which an order can be placed.
     * Only a single sort option can be passed.
     *
     * @param categoryId - Category Id
     * @param locationId - Location Id
     * @param sortBy - Sort option
     * @param offset - offset
     * @param limit - limit
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getSortedItems(
        categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int
    ): Observable<CategoryItemResponse> {
        return catalogueServiceDefault.getSortedItems(categoryId, locationId, sortBy, offset, limit)
    }

    /**
     * returns a list of active recommended items which are sent based on the location id (based on the store)
     *
     * @param locationId - location id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getRecommendedItems(locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask {
        return catalogueServiceDefault.getRecommendedItems(locationId, callback)
    }

    /**
     * returns a list of active recommended items which are sent based on the location id (based on the store)
     *
     * @param locationId - location id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getRecommendedItems(locationId: Int): Observable<RecommendedItemResponse> {
        return catalogueServiceDefault.getRecommendedItems(locationId)
    }

    /**
     * returns a list of items which are sent based on the location id and other items
     * Multiple item id's can be passed as comma separated values Eg( id1,id2,id3 )
     *
     * @param itemId - Item id
     * @param locationId - Location id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getRelatedItems(
        itemId: String, locationId: Int, callback: Callback<RecommendedItemResponse>
    ): CancellableTask {
        return catalogueServiceDefault.getRelatedItems(itemId, locationId, callback)
    }

    /**
     * returns a list of items which are sent based on the location id and other items
     * Multiple item id's can be passed as comma separated values Eg( id1,id2,id3 )
     *
     * @param itemId - Item id
     * @param locationId - Location id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getRelatedItems(itemId: String, locationId: Int): Observable<RecommendedItemResponse> {
        return catalogueServiceDefault.getRelatedItems(itemId, locationId)
    }

    /**
     * This method returns detailed information for a particular ordering item
     *
     * @param itemId - Item id
     * @param locationId - Location id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getItemDetails(
        itemId: Int, locationId: Int, callback: Callback<ItemDetailsResponse>
    ): CancellableTask {
        return catalogueServiceDefault.getItemDetails(itemId, locationId, callback)
    }

    /**
     * This method returns detailed information for a particular ordering item
     *
     * @param itemId - Item id
     * @param locationId - Location id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getItemDetails(itemId: Int, locationId: Int): Observable<ItemDetailsResponse> {
        return catalogueServiceDefault.getItemDetails(itemId, locationId)
    }

    /**
     * This endpoint handles requests made for searching items in the current inventory.
     *
     * The text keyword to search is matched against the item’s title,
     * description and any tags associated with the item.
     *
     * @param query - Keyword
     * @param locationId - Location id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun searchItems(
        query: String, locationId: Int, callback: Callback<CategorySearchResponse>
    ): CancellableTask {
        return catalogueServiceDefault.searchItems(query, locationId, callback)
    }

    /**
     * This endpoint handles requests made for searching items in the current inventory.
     *
     * The text keyword to search is matched against the item’s title,
     * description and any tags associated with the item.
     *
     * @param query - Keyword
     * @param locationId - Location id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun searchItems(query: String, locationId: Int): Observable<CategorySearchResponse> {
        return catalogueServiceDefault.searchItems(query, locationId)
    }

    // ------------------------------- USER SERVICE --------------------------------

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
        return userServiceDefault.login(phone, password, callback)
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
        return userServiceDefault.login(phone, password)
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
        return userServiceDefault.refreshToken(token, callback)
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
        return userServiceDefault.refreshToken(token)
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
    override fun registerUser(
        phone: String, email: String, password: String, name: String, callback: Callback<RegistrationResponse>
    ): CancellableTask {
        return userServiceDefault.registerUser(phone, email, password, name, callback)
    }

    /**
     * This method is used to register a new user
     *
     * @param phone - Phone number
     * @param email - Email
     * @param password - Password
     * @param name - Name
     */
    override fun registerUser(
        phone: String, email: String, password: String, name: String
    ): Observable<RegistrationResponse> {
        return userServiceDefault.registerUser(phone, email, password, name)
    }

    /**
     * This method is used to verify the OTP
     *
     * @param phone - Phone number
     * @param pin - pin
     * @param name - name
     * @param callback - callback to return the result
     */
    override fun verifyOTP(
        phone: String, pin: String, name: String, callback: Callback<RegistrationResponse>
    ): CancellableTask {
        return userServiceDefault.verifyOTP(phone, pin, name, callback)
    }

    /**
     * This method is used to verify the OTP
     *
     * @param phone - Phone number
     * @param pin - Pin
     * @param name - Name
     */
    override fun verifyOTP(phone: String, pin: String, name: String): Observable<RegistrationResponse> {
        return userServiceDefault.verifyOTP(phone, pin, name)
    }

    /**
     * This method is used ot resend the OTP
     *
     * @param phone - Phone number
     * @param callback - callback to return the result
     */
    override fun resendOTP(phone: String, callback: Callback<RegistrationResponse>): CancellableTask {
        return userServiceDefault.resendOTP(phone, callback)
    }

    /**
     * This method is used to resend the OTP
     *
     * @param phone - Phone number
     */
    override fun resendOTP(phone: String): Observable<RegistrationResponse> {
        return userServiceDefault.resendOTP(phone)
    }

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
    override fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String, otp: String,
        callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        return userServiceDefault.socialLoginOTP(email, provider, accessToken, action, phone, otp, callback)
    }

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
    override fun socialLoginOTP(
        email: String, provider: String, accessToken: String, action: String, phone: String, otp: String
    ): Observable<SocialAuthResponse> {
        return userServiceDefault.socialLoginOTP(email, provider, accessToken, action, phone, otp)
    }

    /**
     * TODO
     *
     * @param email
     * @param provider
     * @param accessToken
     * @param callback
     */
    override fun socialLogin(
        email: String, provider: String, accessToken: String, callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        return userServiceDefault.socialLogin(email, provider, accessToken, callback)
    }

    /**
     * TODO
     *
     * @param email
     * @param provider
     * @param accessToken
     */
    override fun socialLogin(email: String, provider: String, accessToken: String): Observable<SocialAuthResponse> {
        return userServiceDefault.socialLogin(email, provider, accessToken)
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
    override fun verifyPhone(
        email: String, phone: String, provider: String, accessToken: String, callback: Callback<SocialAuthResponse>
    ): CancellableTask {
        return userServiceDefault.verifyPhone(email, phone, provider, accessToken, callback)
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
    override fun verifyPhone(
        email: String, phone: String, provider: String, accessToken: String
    ): Observable<SocialAuthResponse> {
        return userServiceDefault.verifyPhone(email, phone, provider, accessToken)
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
        return userServiceDefault.refreshUserInfo(phone, callback)
    }

    /**
     * Returns the profile data associated with a particular user identified by his/her phone number.
     *
     * @param phone - Phone number
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun refreshUserInfo(phone: String): Observable<UserInfoResponse> {
        return userServiceDefault.refreshUserInfo(phone)
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
        phone: String, body: UpdateUserInfoBody, callback: Callback<UpdateUserInfoResponse>
    ): CancellableTask {
        return userServiceDefault.updateUserInfo(phone, body, callback)
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
        return userServiceDefault.updateUserInfo(phone, body)
    }

    /**
     * Returns the profile data associated with a particular user identified by his/her phone number.
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun refreshUserBizInfo(callback: Callback<UserBizInfoResponse>): CancellableTask {
        return userServiceDefault.refreshUserBizInfo(callback)
    }

    /**
     * Returns the profile data associated with a particular user identified by his/her phone number.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun refreshUserBizInfo(): Observable<UserBizInfoResponse> {
        return userServiceDefault.refreshUserBizInfo()
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
        return userServiceDefault.changePassword(oldPassword, newPassword, confirmPassword, phone, callback)
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
        oldPassword: String, newPassword: String, confirmPassword: String, phone: String
    ): Observable<GenericResponse> {
        return userServiceDefault.changePassword(oldPassword, newPassword, confirmPassword, phone)
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
        locationId: String, callback: Callback<DeliverableAddressResponse>
    ): CancellableTask {
        return userServiceDefault.getDeliverableAddresses(locationId, callback)
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
        return userServiceDefault.getDeliverableAddresses(locationId)
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
        return userServiceDefault.addAddress(userAddress, callback)
    }


    /**
     * This method adds a new address for the user
     *
     * @param userAddress - UserAddress Object
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun addAddress(userAddress: UserAddress): Observable<UserAddressSaveResponse> {
        return userServiceDefault.addAddress(userAddress)
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
        return userServiceDefault.updateAddress(userAddress, callback)
    }

    /**
     * This method adds a updates an existing address for the user
     *
     * @param userAddress - UserAddress Object
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun updateAddress(userAddress: UserAddress): Observable<UserAddressSaveResponse> {
        return userServiceDefault.updateAddress(userAddress)
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
        return userServiceDefault.deleteAddress(addressId, callback)
    }

    /**
     * This method deletes an existing address for a user
     *
     * @param addressId - Address id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun deleteAddress(addressId: String): Observable<UserAddressSaveResponse> {
        return userServiceDefault.deleteAddress(addressId)
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
        limit: String, offset: String, callback: Callback<TransactionsResponse>
    ): CancellableTask {
        return userServiceDefault.getWalletTransactions(limit, offset, callback)
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
        return userServiceDefault.getWalletTransactions(limit, offset)
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
    override fun getPastOrders(callback: Callback<OrderHistoryV2Response>): CancellableTask {
        return userServiceDefault.getPastOrders(callback)
    }

    /**
     * This endpoint returns the list of orders placed by a user in the past. Only the summary data
     * for each order is returned. This should be used when a client needs to display the past orders placed
     * by a user.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getPastOrders(): Observable<OrderHistoryV2Response> {
        return userServiceDefault.getPastOrders()
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
        return userServiceDefault.getPastOrderDetails(orderId, callback)
    }

    /**
     * Returns details information about an order
     *
     * @param orderId - Order id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getPastOrderDetails(orderId: Int): Observable<OrderDetailResponse> {
        return userServiceDefault.getPastOrderDetails(orderId)
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
        return userServiceDefault.redeemReward(rewardId, callback)
    }

    /**
     * This method redeems a reward for a user
     *
     * @param rewardId - Id of the reward
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun redeemReward(rewardId: Int): Observable<RedeemRewardResponse> {
        return userServiceDefault.redeemReward(rewardId)
    }

    /**
     * This method returns a list of all the notifications that was sent to that user
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getNotifications(callback: Callback<UserbizNotificationsResponse>): CancellableTask {
        return userServiceDefault.getNotifications(callback)
    }

    /**
     * This method returns a list of all the notifications that was sent to that user
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getNotifications(): Observable<UserbizNotificationsResponse> {
        return userServiceDefault.getNotifications()
    }

    /**
     * Submit feedback for the order
     *
     * @param feedback
     * @param callback
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun submitFeedback(feedback: UserFeedback, callback: Callback<SimpleResponse>): CancellableTask {
        return userServiceDefault.submitFeedback(feedback, callback)
    }

    /**
     * Submit feedback for the order
     *
     * @param feedback
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun submitFeedback(feedback: UserFeedback): Observable<SimpleResponse> {
        return userServiceDefault.submitFeedback(feedback)
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
        return userServiceDefault.getUserLikes(ids, callback)
    }

    /**
     * Returns a list of likes for item id's passed as (eg - id1,id2,id3)
     *
     * @param ids - Item id's passed as a comma separated values (eg - id1,id2,id3)
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getUserLikes(ids: String): Observable<UserLikesResponse> {
        return userServiceDefault.getUserLikes(ids)
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
        return userServiceDefault.likeItem(itemId, callback)
    }

    /**
     * This method likes an item based on the item id
     *
     * @param itemId - Item id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun likeItem(itemId: Int): Observable<Like> {
        return userServiceDefault.likeItem(itemId)
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
        return userServiceDefault.unLikeItem(itemId, callback)
    }

    /**
     * This method un likes an item based on the item id
     *
     * @param itemId - Item id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun unLikeItem(itemId: Int): Observable<Like> {
        return userServiceDefault.unLikeItem(itemId)
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
    override fun getResetPasswordToken(phone: String, callback: Callback<GenericResponse>): CancellableTask {
        return userServiceDefault.getResetPasswordToken(phone, callback)
    }

    /**
     * This method generates a password reset token that is sent to the user through
     * SMS and phone
     *
     * @param phone - Phone number
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getResetPasswordToken(phone: String): Observable<GenericResponse> {
        return userServiceDefault.getResetPasswordToken(phone)
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
    override fun resetPassword(
        phone: String, newPassword: String, confirmPassword: String, token: String,
        callback: Callback<GenericResponse>
    ): CancellableTask {
        return userServiceDefault.resetPassword(phone, newPassword, confirmPassword, token, callback)
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
    override fun resetPassword(
        phone: String, newPassword: String, confirmPassword: String, token: String
    ): Observable<GenericResponse> {
        return userServiceDefault.resetPassword(phone, newPassword, confirmPassword, token)
    }

    // ------------------------ PROMOTIONS SERVICE -------------------------------

    /**
     * The Gallery method returns the list of images that have been uploaded through the configuration portal.
     *
     * These images might be used for different visual purposes, such as:
     * - showing banners in a carousel in the website or app.
     * - showing a promotional popup.
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getBanners(callback: Callback<BannerResponse>): CancellableTask {
        return promotionsServiceDefault.getBanners(callback)
    }

    /**
     * The Gallery method returns the list of images that have been uploaded through the configuration portal.
     *
     * These images might be used for different visual purposes, such as:
     * - showing banners in a carousel in the website or app.
     * - showing a promotional popup.
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getBanners(): Observable<BannerResponse> {
        return promotionsServiceDefault.getBanners()
    }

    /**
     * This method returns a list of offers that can be applied to an order
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getCoupons(callback: Callback<OffersResponse>): CancellableTask {
        return promotionsServiceDefault.getCoupons(callback)
    }

    /**
     * This method returns a list of offers that can be applied to an order
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getCoupons(): Observable<OffersResponse> {
        return promotionsServiceDefault.getCoupons()
    }

    /**
     * This endpoint returns the list of rewards that are configured in the system.
     * Rewards might be in one of the following states for a user
     *
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getRewards(callback: Callback<RewardsResponse>): CancellableTask {
        return promotionsServiceDefault.getRewards(callback)
    }

    /**
     * This endpoint returns the list of rewards that are configured in the system.
     * Rewards might be in one of the following states for a user
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getRewards(): Observable<RewardsResponse> {
        return promotionsServiceDefault.getRewards()
    }
    // ------------------------ CART SERVICE -------------------------------

    /**
     * This endpoint validates whether a previously placed order can be re-ordered.
     * The response indicates which items can be re-ordered and which can’t be.
     *
     * @param orderId - Order Id
     * @param locationId - Location Id
     * @param lat - user's current latitude
     * @param lng - user's current longitude
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun reOrder(
        orderId: String, locationId: String, lat: String, lng: String, callback: Callback<ReOrderResponse>
    ): CancellableTask {
        return cartServiceDefault.reOrder(orderId, locationId, lat, lng, callback)
    }

    /**
     * This endpoint validates whether a previously placed order can be re-ordered.
     * The response indicates which items can be re-ordered and which can’t be.
     *
     * @param orderId - Order Id
     * @param locationId - Location Id
     * @param lat - user's current latitude
     * @param lng - user's current longitude
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun reOrder(orderId: String, locationId: String, lat: String, lng: String): Observable<ReOrderResponse> {
        return cartServiceDefault.reOrder(orderId, locationId, lat, lng)
    }

    /**
     * returns a list of items which are sent based on the location id and other items
     * Multiple item id's can be passed as comma separated values Eg( id1,id2,id3 )
     *
     * @param itemIds - Item id
     * @param locationId - Location id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun getCartRelatedItems(
        itemIds: String, locationId: Int, callback: Callback<RecommendedItemResponse>
    ): CancellableTask {
        return cartServiceDefault.getCartRelatedItems(itemIds, locationId, callback)
    }

    /**
     * returns a list of items which are sent based on the location id and other items
     * Multiple item id's can be passed as comma separated values Eg( id1,id2,id3 )
     *
     * @param itemIds - Item id
     * @param locationId - Location id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun getCartRelatedItems(itemIds: String, locationId: Int): Observable<RecommendedItemResponse> {
        return cartServiceDefault.getCartRelatedItems(itemIds, locationId)
    }

    /**
     * This is an important method in the flow of placing an order. This endpoint validates the contents
     * of the cart to return the computational details for the order, like the charges, taxes, total, etc.
     * We strongly recommend client applications not to perform these complex computations at their end,
     * since there are many variables that can affect the computations—not all of which are available with
     * the client application at any time.
     *
     * @param order - Order object
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun validateCart(order: Order, callback: Callback<ValidateCartResponse>): CancellableTask {
        return cartServiceDefault.validateCart(order, callback)
    }

    /**
     * This is an important method in the flow of placing an order. This endpoint validates the contents
     * of the cart to return the computational details for the order, like the charges, taxes, total, etc.
     * We strongly recommend client applications not to perform these complex computations at their end,
     * since there are many variables that can affect the computations—not all of which are available with
     * the client application at any time.
     *
     * @param order - Order object
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun validateCart(order: Order): Observable<ValidateCartResponse> {
        return cartServiceDefault.validateCart(order)
    }

    /**
     * This endpoint accepts a coupon code and the current order data to determine whether the coupon
     * can be applied, and what the discount value would be. The Order information is required for this
     * endpoint to function since a coupon’s validity is usually tied to the current order data.
     *
     * @param couponCode - Coupon code
     * @param body - Validate coupon body
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    override fun validateCoupon(
        couponCode: String, body: ValidateCouponBody, callback: Callback<OrderValidateCouponResponse>
    ): CancellableTask {
        return cartServiceDefault.validateCoupon(couponCode, body, callback)
    }

    /**
     * This endpoint accepts a coupon code and the current order data to determine whether the coupon
     * can be applied, and what the discount value would be. The Order information is required for this
     * endpoint to function since a coupon’s validity is usually tied to the current order data.
     *
     * @param couponCode - Coupon code
     * @param body - Validate coupon body
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    override fun validateCoupon(couponCode: String, body: ValidateCouponBody): Observable<OrderValidateCouponResponse> {
        return cartServiceDefault.validateCoupon(couponCode, body)
    }

    /**
     * Initiates a payment for the particular biz's store.
     *
     * @param storeId - Store id
     * @param amount - amount
     * @param redirectUrl - redirect url
     * @param paytm - paytm
     * @param simpl - simpl
     * @param callback - Callback to return the result
     */
    override fun initPayment(
        storeId: Int, amount: Int, redirectUrl: String, paytm: String?, simpl: String?,
        callback: Callback<PaymentInitResponse>
    ): CancellableTask {
        return cartServiceDefault.initPayment(storeId, amount, redirectUrl, paytm, simpl, callback)
    }

    /**
     * Initiates a payment for the particular biz's store.
     *
     * @param storeId - Store id
     * @param amount - amount
     * @param redirectUrl - redirect url
     * @param paytm - paytm
     * @param simpl - simpl
     */
    override fun initPayment(
        storeId: Int, amount: Int, redirectUrl: String, paytm: String?, simpl: String?
    ): Observable<PaymentInitResponse> {
        return cartServiceDefault.initPayment(storeId, amount, redirectUrl, paytm, simpl)
    }

    /**
     * Initiates a payment for the particular biz's store.
     *
     * @param storeId - Store id
     * @param amount - amount
     * @param redirectUrl - redirect url
     * @param paytm - paytm
     * @param simpl - simpl
     * @param callback - Callback to return the result
     */
    override fun initWalletReload(
        storeId: Int, amount: Int, redirectUrl: String, paytm: String, simpl: String,
        callback: Callback<PaymentInitResponse>
    ): CancellableTask {
        return cartServiceDefault.initWalletReload(storeId, amount, redirectUrl, paytm, simpl, callback)
    }

    /**
     * Initiates a payment for the particular biz's store.
     *
     * @param storeId
     * @param amount
     * @param redirectUrl
     * @param paytm
     * @param simpl
     */
    override fun initWalletReload(
        storeId: Int, amount: Int, redirectUrl: String, paytm: String, simpl: String
    ): Observable<PaymentInitResponse> {
        return cartServiceDefault.initWalletReload(storeId, amount, redirectUrl, paytm, simpl)
    }

    /**
     * Sends the order details to the server
     *
     * @param body - Order object
     * @param callback - Callback to return the result
     */
    override fun placeOrder(body: Order, callback: Callback<OrderSaveResponse>): CancellableTask {
        return cartServiceDefault.placeOrder(body, callback)
    }

    /**
     * Sends the order details to the server
     *
     * @param body - Order object
     */
    override fun placeOrder(body: Order): Observable<OrderSaveResponse> {
        return cartServiceDefault.placeOrder(body)
    }

    /**
     * Verify payment after transaction is complete
     *
     * @param transactionId - transaction id
     * @param gwTxnId - payment gateway transaction id
     * @param transactionStatus - transactionStatus
     * @param callback - callback to return the result
     */
    override fun verifyPayment(
        transactionId: String, gwTxnId: String, transactionStatus: Int, callback: Callback<PaymentCallbackResponse>
    ): CancellableTask {
        return cartServiceDefault.verifyPayment(transactionId, gwTxnId, transactionStatus, callback)
    }

    /**
     * Verify payment after transaction is complete
     *
     * @param transactionId - transaction id
     * @param gwTxnId - payment gateway transaction id
     * @param transactionStatus - transactionStatus
     */
    override fun verifyPayment(
        transactionId: String, gwTxnId: String, transactionStatus: Int
    ): Observable<PaymentCallbackResponse> {
        return cartServiceDefault.verifyPayment(transactionId, gwTxnId, transactionStatus)
    }

    /**
     * This method returns a reference to a singleton instance of a cart
     *
     * @return Cart - The method returns an instance of a cart
     */
    override fun getCart(): Cart {
        return cartServiceDefault.getCart()
    }

    /**
     * This method returns an instance of the Registration Builder
     */
    override fun getRegistrationBuilder(): RegistrationBuilder {
        return RegistrationBuilder(userServiceDefault)
    }

    /**
     * This method returns an instance of the Checkout Builder
     */
    override fun getCheckOutBuilder(): CheckoutBuilder {
        return CheckoutBuilder(cartServiceDefault)
    }

    /**
     * This method returns an instance of the reset password builder
     */
    override fun getResetPasswordBuilder(): ResetPasswordBuilder {
        return ResetPasswordBuilder(userServiceDefault)
    }

    /**
     * This method returns an instance of the social reg builder
     */
    override fun getSocialRegBuilder(): SocialRegBuilder {
        return SocialRegBuilder(userServiceDefault)
    }

    /**
     * This method returns an instance of the item option builder
     */
    override fun getItemOptionBuilder(): ItemOptionBuilder {
        return ItemOptionBuilder()
    }
}