package com.urbanpiper.upsdk.dataprovider

import retrofit2.Call
import retrofit2.http.*
import com.urbanpiper.upsdk.model.networkresponse.*

interface CatalogueRetrofitService {

    /**
     * Retrieves all the available categories available for
     * ordering.
     *
     * @param bizId - Id of biz id
     * @param locationId - Optional. If present, categories for that location would be fetched.
     * @param authToken - Auth token
     * @param cacheControl - pass null if caching is ok, else, pass "no-cache".
     */
    @GET("/api/v1/order/categories/")
    fun getCategories(
        @Header("Authorization") authToken: String
        , @Header("cache-control") cacheControl: String = "no-cache"
        , @Query("biz_id") bizId: String
        , @Query("location_id") locationId: Int
    ): Call<OrderCategoriesResponse>

    /**
     * Retrieves the list of items available under a particular category.
     *
     * @param categoryId - Category Id
     * @param bizId - Business id biz Id
     * @param authToken -getProducts Authentication
     * @param offset - offset
     * @param limit - limit
     */
    @GET("/api/v1/order/categories/{category_id}/items/")
    fun getItems(
        @Header("Authorization") authToken: String
        , @Path("category_id") categoryId: Int
        , @Query("location_id") locationId: String
        , @Query("biz_id") bizId: String
        , @Query("offset") offset: Int
        , @Query("limit") limit: Int
    ): Call<CartItemResponse>

    /**
     * Get the filter and sort options for a particular category
     *
     * @param categoryId - Id of the category
     * @param authToken  - Auth token
     */
    @GET("/api/v2/categories/{category_id}/options/")
    fun getFilterSortOptions(
        @Header("Authorization") authToken: String
        , @Path("category_id") categoryId: Int
    ): Call<FilterAndSortOptionsResponse>

    /**
     * Retrieves the list of items available under a particular category with filters applied.
     *
     * @param categoryId
     * @param bizId
     * @param locationId
     * @param filterBy
     * @param offset
     * @param limit
     * @param authToken
     */
    @GET("/api/v1/order/categories/{category_id}/items/")
    fun getFilteredItems(
        @Header("Authorization") authToken: String
        , @Path("category_id") categoryId: Int
        , @Query("location_id") locationId: String
        , @Query("filter_by") filterBy: String
        , @Query("biz_id") bizId: String
        , @Query("offset") offset: Int
        , @Query("limit") limit: Int
    ): Call<CartItemResponse>

    /**
     * Retrieves a list of items sorted by the sort option selected
     *
     * @param categoryId
     * @param bizId
     * @param locationId
     * @param sortBy
     * @param offset
     * @param limit
     * @param authToken
     */
    @GET("/api/v1/order/categories/{category_id}/items/")
    fun getSortedItems(
        @Header("Authorization") authToken: String
        , @Path("category_id") categoryId: Int
        , @Query("location_id") locationId: String
        , @Query("sort_by") sortBy: String
        , @Query("biz_id") bizId: String
        , @Query("offset") offset: Int
        , @Query("limit") limit: Int
    ): Call<CartItemResponse>

    /**
     * Get the featured items from the server
     *
     * @param locationId - Id of the nearest store
     * @param authToken  - Auth token
     */
    @GET("/api/v2/items/0/recommendations/")
    fun getFeaturedItems(
        @Header("Authorization") authToken: String
        , @Query("location_id") locationId: Int
    ): Call<RecommendedItemResponse>

    /**
     * Get the recommended items from the server. The items returned are based on a particular item
     * in details or checkout page.
     *
     * @param itemId - Comma separated item id's or single item.
     * @param locationId - Id of the nearest store
     * @param authToken  - Auth token
     */
    @GET("/api/v2/items/{item_id}/recommendations/")
    fun getRecommendedItems(
        @Header("Authorization") authToken: String
        , @Path("item_id") itemId: String
        , @Query("location_id") locationId: Int
    ): Call<RecommendedItemResponse>

    /**
     * Retrieves the item details for item.
     *
     * @param itemId
     * @param storeId
     */
    @GET("/api/v1/items/{item_id}/")
    fun getItemDetails(
        @Header("Authorization") authToken: String
        , @Path("item_id") itemId: Int
        , @Query("location_id") locationId: Int
        , @Query("cb") cacheBuster: Long
    ): Call<OrderItemResponse>

    /**
     * Retrieves order items based on search items
     * ordering.
     *
     * @param query
     * @param authToken
     */
    @GET("/api/v2/search/items/")
    fun searchItems(
        @Header("Authorization") authToken: String,
        @Query("keyword") query: String,
        @Query("location_id") location: Int
    ): Call<OrderItemsSearchResponse>

//    /**
//     * Sends the order details to the server for pre-processing.
//     *
//     * @param order
//     * @param bizId
//     * @param preProcOpt
//     * @param authToken
//     */
//    @POST("/api/v1/order/")
//    fun preProcessOrder(
//        @Body order: Order
//        , @Header("Authorization") authToken: String
//        , @Query("pre_proc") preProcOpt: Int
//        , @Query("biz_id") bizId: String
//    ): Call<PreProcessOrderResponse>

//    /**
//     * Fetches the summary data for orders placed in the past by a
//     * user.
//     *
//     * @param authToken - Authorization token
//     */
//    @GET("/api/v2/orders/")
//    fun fetchOrderHistory(
//        @Header("Authorization") authToken: String
//    ): Call<OrderHistoryResponse>
//    /**
//     * Sends the order details to the server for persistence.
//     *
//     * @param order
//     * @param bizId
//     * @param authToken
//     */
//    @POST("/api/v1/order/")
//    fun saveOrder(
//        @Body order: Order
//        , @Header("Authorization") authToken: String
//        , @Query("biz_id") bizId: String
//    ): Call<OrderSaveResponse>
//
//    /**
//     * Advanced version of coupon validation - takes in the complete
//     * order data as request body.
//     *
//     * @param couponCode
//     * @param requestData
//     * @param authToken
//     */
//    @POST("/api/v1/coupons/{coupon_code}/")
//    fun validateCoupon(
//        @Body requestData: ValidateCouponPayload
//        , @Header("Authorization") authToken: String
//        , @Path("coupon_code") couponCode: String
//    ): Call<OrderValidateCouponResponse>
//
//
//    /**
//     * For saving a user's address for order delivery.
//     *
//     * @param authToken
//     */
//    @POST("/api/v1/user/address/?format=json")
//    fun saveUserAddress(
//        @Body address: UserAddress
//        , @Header("Authorization") authToken: String
//    ): Call<UserAddressSaveResponse>
//
//    /**
//     * Deletes a previously stored user address.
//     *
//     * @param authToken
//     * @param addressId
//     */
//    @DELETE("/api/v1/user/address/{address_id}/")
//    fun deleteUserAddress(
//        @Header("Authorization") authToken: String
//        , @Path("address_id") addressId: String
//    ): Call<UserAddressSaveResponse>
//
//    /**
//     * Gets a list of addresses for the user. Each address has a field deliverable which
//     * will be true/false based on the current location id.
//     *
//     * @param authToken - It is logged in user auth
//     * @param location  - Location id of the store
//     */
//    @GET("/api/v1/user/address/")
//    fun getDeliverableAddress(
//        @Header("Authorization") authToken: String,
//        @Query("location_id") location: String
//    ): Call<UserAddressDeliverableV3>
//
//    /**
//     * For saving the feedback associated with an order.
//     *
//     * @param authToken
//     * @param feedback
//     */
//    @POST("/api/v2/feedback/")
//    fun saveFeedback(
//        @Body feedback: UserFeedback,
//        @Header("Authorization") authToken: String
//    ): Call<SimpleResponse>
//
//    /**
//     * For saving the feedback associated with an order.
//     *
//     * @param authToken
//     * @param storeId
//     * @param query
//     */
//    @GET("/api/v2/store/{store_id}/pod/")
//    fun fetchPointsOfDelivery(
//        @Header("Authorization") authToken: String,
//        @Path("store_id") storeId: Int,
//        @Query("q") query: String
//    ): Call<PointsOfDeliveryResponse>
//
//    /**
//     * re-order api
//     *
//     * @param authToken - Authorization token
//     * @param orderID
//     * @param lat
//     * @param lng
//     * @param location_id
//     */
//    @GET("/api/v2/order/{id}/reorder/")
//    fun reOrder(
//        @Header("Authorization") authToken: String,
//        @Path("id") orderID: String,
//        @Query("location_id") location_id: String,
//        @Query("lat") lat: String,
//        @Query("lng") lng: String
//    ): Call<ReOrderResponse>
//
//    /**
//     * Fetches the summary data for orders placed in the past by a
//     * user.
//     *
//     * @param authToken
//     */
//    @GET("/api/v2/orders/{order_id}/")
//    fun fetchOrderDetails(
//        @Header("Authorization") authToken: String,
//        @Path("order_id") orderId: Int
//    ): Call<OrderDetailResponse>
//

}