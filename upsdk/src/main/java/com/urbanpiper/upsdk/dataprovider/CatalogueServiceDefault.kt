package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.*
import retrofit2.Callback
import retrofit2.Retrofit

class CatalogueServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) :
    CatalogueService {

    private val orderingRetrofitService: CatalogueRetrofitService =
        retrofit.create(CatalogueRetrofitService::class.java)

    override fun getCategories(locationId: Int, callback: Callback<CategoriesResponse>): CancellableTask {
        val getCategoriesCall = orderingRetrofitService.getCategories(authToken, "no-cache", bizId, locationId)
        getCategoriesCall.clone().enqueue(callback)
        return CancellableTaskWrapper(getCategoriesCall)
    }

    override fun getCategoryItems(
        categoryId: Int, locationId: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>
    ): CancellableTask {
        val getItemsCall = orderingRetrofitService.getItems(authToken, categoryId, locationId, bizId, offset, limit)
        getItemsCall.clone().enqueue(callback)
        return CancellableTaskWrapper(getItemsCall)
    }

    override fun getFilterAndSortOptions(
        categoryId: Int, callback: Callback<FilterAndSortOptionsResponse>
    ): CancellableTask {
        val getFilterAndSortOptionsCall = orderingRetrofitService.getFilterSortOptions(authToken, categoryId)
        getFilterAndSortOptionsCall.clone().enqueue(callback)
        return CancellableTaskWrapper(getFilterAndSortOptionsCall)
    }

    override fun getFilteredItems(
        categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int,
        callback: Callback<CategoryItemResponse>
    ): CancellableTask {
        val getFilteredItemsCall =
            orderingRetrofitService.getFilteredItems(authToken, categoryId, locationId, filterBy, bizId, offset, limit)
        getFilteredItemsCall.clone().enqueue(callback)
        return CancellableTaskWrapper(getFilteredItemsCall)
    }

    override fun getSortedItems(
        categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int,
        callback: Callback<CategoryItemResponse>
    ): CancellableTask {
        val getFilteredItemsCall =
            orderingRetrofitService.getSortedItems(authToken, categoryId, locationId, sortBy, bizId, offset, limit)
        getFilteredItemsCall.clone().enqueue(callback)
        return CancellableTaskWrapper(getFilteredItemsCall)
    }

    override fun getRecommendedItems(locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask {
        val featuredItems = orderingRetrofitService.getFeaturedItems(authToken, locationId)
        featuredItems.clone().enqueue(callback)
        return CancellableTaskWrapper(featuredItems)
    }

    override fun getRelatedItems(
        itemId: String, locationId: Int, callback: Callback<RecommendedItemResponse>
    ): CancellableTask {
        val recommendedItems = orderingRetrofitService.getRecommendedItems(authToken, itemId, locationId)
        recommendedItems.clone().enqueue(callback)
        return CancellableTaskWrapper(recommendedItems)
    }

    override fun getItemDetails(
        itemId: Int, locationId: Int, callback: Callback<ItemDetailsResponse>
    ): CancellableTask {
        val itemDetailsCall = orderingRetrofitService.getItemDetails(authToken, itemId, locationId)
        itemDetailsCall.clone().enqueue(callback)
        return CancellableTaskWrapper(itemDetailsCall)
    }

    override fun searchItems(
        query: String, locationId: Int, callback: Callback<CategorySearchResponse>
    ): CancellableTask {
        val searchItems = orderingRetrofitService.searchItems(authToken, query, locationId)
        searchItems.clone().enqueue(callback)
        return CancellableTaskWrapper(searchItems)
    }


}