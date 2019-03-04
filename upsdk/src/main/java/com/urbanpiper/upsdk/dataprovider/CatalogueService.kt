package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableAll

interface CatalogueService {

    /**
     * Get all the categories
     */
    fun getCategories(locationId: Int, callback: Callback<CategoriesResponse>): CancellableTask


    /**
     * Get all the categories
     */
    fun getCategories(locationId: Int): Observable<CategoriesResponse>

    /**
     * Get items for a particular category
     */
    fun getCategoryItems(categoryId: Int, locationId: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>): CancellableTask

    /**
     * Get items for a particular category
     */
    fun getCategoryItems(categoryId: Int, locationId: String, offset: Int, limit: Int): Observable<CategoryItemResponse>


    /**
     * Get filter and sort options for a particular category
     */
    fun getFilterAndSortOptions(categoryId: Int, callback: Callback<FilterAndSortOptionsResponse>) : CancellableTask

    /**
     * Get filter and sort options for a particular category
     */
    fun getFilterAndSortOptions(categoryId: Int ) : Observable<FilterAndSortOptionsResponse>


    /**
     * Get filtered items for a particular category
     */
    fun getFilteredItems(categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>): CancellableTask

    /**
     * Get filtered items for a particular category
     */
    fun getFilteredItems(categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int): Observable<CategoryItemResponse>

    /**
     * Get sorted items for a particular category
     */
    fun getSortedItems(categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>): CancellableTask

    /**
     * Get sorted items for a particular category
     */
    fun getSortedItems(categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int): Observable<CategoryItemResponse>

    /**
     * Get recommended items
     */
    fun getRecommendedItems(locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask

    /**
     * Get recommended items
     */
    fun getRecommendedItems(locationId: Int): Observable<RecommendedItemResponse>

    /**
     * Get Related items
     */
    fun getRelatedItems(itemId: String, locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask

    /**
     * Get Related items
     */
    fun getRelatedItems(itemId: String, locationId: Int): Observable<RecommendedItemResponse>

    /**
     * Get Item Details
     */
    fun getItemDetails(itemId: Int, locationId: Int, callback: Callback<ItemDetailsResponse>): CancellableTask

    /**
     * Get Item Details
     */
    fun getItemDetails(itemId: Int, locationId: Int): Observable<ItemDetailsResponse>


    /**
     * Search for items
     */
    fun searchItems(query: String, locationId: Int, callback: Callback<CategorySearchResponse>): CancellableTask

    /**
     * Search for items
     */
    fun searchItems(query: String, locationId: Int): Observable<CategorySearchResponse>

}