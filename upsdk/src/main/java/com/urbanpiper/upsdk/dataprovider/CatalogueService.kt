package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.*
import retrofit2.Callback

interface CatalogueService {

    /**
     * Get all the categories
     */
    fun getCategories(locationId: Int, callback: Callback<CategoriesResponse>): CancellableTask

    /**
     * Get items for a particular category
     */
    fun getCategoryItems(categoryId: Int, locationId: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>): CancellableTask

    /**
     * Get filter and sort options for a particular category
     */
    fun getFilterAndSortOptions(categoryId: Int, callback: Callback<FilterAndSortOptionsResponse>) : CancellableTask

    /**
     * Get filtered items for a particular category
     */
    fun getFilteredItems(categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>): CancellableTask

    /**
     * Get sorted items for a particular category
     */
    fun getSortByItems(categoryId: Int, locationId: String, sortBy: String ,offset: Int, limit: Int, callback: Callback<CategoryItemResponse>): CancellableTask

    /**
     * Get recommended items
     */
    fun getRecommendedItems(locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask

    /**
     * Get Related items
     */
    fun getRelatedItems(itemId: String, locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask

    /**
     * Get Item Details
     */
    fun getItemDetails(itemId: Int, locationId: Int, callback: Callback<ItemDetailsResponse>): CancellableTask

    /**
     * Search for items
     */
    fun searchItems(query: String, locationId: Int, callback: Callback<CategorySearchResponse>): CancellableTask
}