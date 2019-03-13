package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableAll

/**
 * List of methods related to the catalogue
 *
 */
interface CatalogueService {

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
    fun getCategories(locationId: Int, callback: Callback<CategoriesResponse>): CancellableTask


    /**
     * returns a list of active categories of items from which an order can be placed
     *
     * This method returns the list of active categories of items from which an order can be placed.
     *
     * @param locationId - Location id is returned from the store
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getCategories(locationId: Int): Observable<CategoriesResponse>

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
    fun getCategoryItems(categoryId: Int, locationId: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>): CancellableTask

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
    fun getCategoryItems(categoryId: Int, locationId: String, offset: Int, limit: Int): Observable<CategoryItemResponse>

    /**
     * This endpoint handles requests to get available filter and sort options for a category.
     *
     * @param categoryId - Category Id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getFilterAndSortOptions(categoryId: Int, callback: Callback<FilterAndSortOptionsResponse>) : CancellableTask

    /**
     * This endpoint handles requests to get available filter and sort options for a category.
     *
     * @param categoryId - Category Id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getFilterAndSortOptions(categoryId: Int ) : Observable<FilterAndSortOptionsResponse>


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
    fun getFilteredItems(categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>): CancellableTask

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
    fun getFilteredItems(categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int): Observable<CategoryItemResponse>

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
    fun getSortedItems(categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>): CancellableTask

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
    fun getSortedItems(categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int): Observable<CategoryItemResponse>

    /**
     * returns a list of active recommended items which are sent based on the location id (based on the store)
     *
     * @param locationId - location id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getRecommendedItems(locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask

    /**
     * returns a list of active recommended items which are sent based on the location id (based on the store)
     *
     * @param locationId - location id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getRecommendedItems(locationId: Int): Observable<RecommendedItemResponse>

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
    fun getRelatedItems(itemId: String, locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask

    /**
     * returns a list of items which are sent based on the location id and other items
     * Multiple item id's can be passed as comma separated values Eg( id1,id2,id3 )
     *
     * @param itemId - Item id
     * @param locationId - Location id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getRelatedItems(itemId: String, locationId: Int): Observable<RecommendedItemResponse>

    /**
     * This method returns detailed information for a particular ordering item
     *
     * @param itemId - Item id
     * @param locationId - Location id
     * @param callback - Callback to return the result
     *
     * @return CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask
     */
    fun getItemDetails(itemId: Int, locationId: Int, callback: Callback<ItemDetailsResponse>): CancellableTask

    /**
     * This method returns detailed information for a particular ordering item
     *
     * @param itemId - Item id
     * @param locationId - Location id
     *
     * @return Observable - the result of the network request is returned as an Observable
     */
    fun getItemDetails(itemId: Int, locationId: Int): Observable<ItemDetailsResponse>


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
    fun searchItems(query: String, locationId: Int, callback: Callback<CategorySearchResponse>): CancellableTask

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
    fun searchItems(query: String, locationId: Int): Observable<CategorySearchResponse>

}