package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.*
import retrofit2.Callback

interface OrderingService {

    /**
     * Get all the categories
     */
    fun getCategories(locationId: Int, callback: Callback<OrderCategoriesResponse>): CancellableTask

    /**
     * Get items for a particular category
     */
    fun getItems(categoryId: Int, locationId: String, offset: Int, limit: Int, callback: Callback<CartItemResponse>): CancellableTask

    /**
     * Get filter and sort options for a particular category
     */
    fun getFilterAndSortOptions(categoryId: Int, callback: Callback<FilterAndSortOptionsResponse>) : CancellableTask

    /**
     * Get filtered items for a particular category
     */
    fun getFilteredItems(categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int, callback: Callback<CartItemResponse>): CancellableTask

    /**
     * Get sorted items for a particular category
     */
    fun getSortByItems(categoryId: Int, locationId: String, sortBy: String ,offset: Int, limit: Int, callback: Callback<CartItemResponse>): CancellableTask

    /**
     * Get featured items
     */
    fun getFeaturedItems(locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask

    /**
     * Get Recommended items
     */
    fun getRecommendedItems(itemId: String, locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask

    /**
     * Get Item Details
     */
    fun getItemDetails(itemId: Int, locationId: Int, cacheBuster: Long, callback: Callback<OrderItemResponse>): CancellableTask

}