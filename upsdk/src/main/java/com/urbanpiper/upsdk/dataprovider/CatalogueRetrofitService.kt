package com.urbanpiper.upsdk.dataprovider

import retrofit2.http.*
import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable

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
    ): Observable<CategoriesResponse>

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
    fun getCategoryItems(
        @Header("Authorization") authToken: String
        , @Path("category_id") categoryId: Int
        , @Query("location_id") locationId: String
        , @Query("biz_id") bizId: String
        , @Query("offset") offset: Int
        , @Query("limit") limit: Int
    ): Observable<CategoryItemResponse>

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
    ): Observable<FilterAndSortOptionsResponse>

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
    ): Observable<CategoryItemResponse>

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
    ): Observable<CategoryItemResponse>

    /**
     * Get the featured items from the server
     *
     * @param locationId - Id of the nearest store
     * @param authToken  - Auth token
     */
    @GET("/api/v2/items/0/recommendations/")
    fun getRecommendedItems(
        @Header("Authorization") authToken: String
        , @Query("location_id") locationId: Int
    ): Observable<RecommendedItemResponse>

    /**
     * Get the recommended items from the server. The items returned are based on a particular item
     * in details or checkout page.
     *
     * @param itemId - Comma separated item id's or single item.
     * @param locationId - Id of the nearest store
     * @param authToken  - Auth token
     */
    @GET("/api/v2/items/{item_id}/recommendations/")
    fun getRelatedItems(
        @Header("Authorization") authToken: String
        , @Path("item_id") itemId: String
        , @Query("location_id") locationId: Int
    ): Observable<RecommendedItemResponse>

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
    ): Observable<ItemDetailsResponse>

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
    ): Observable<CategorySearchResponse>
}