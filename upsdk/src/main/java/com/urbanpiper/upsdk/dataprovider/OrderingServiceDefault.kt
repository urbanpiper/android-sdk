package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.*
import retrofit2.Callback
import retrofit2.Retrofit

class OrderingServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) :
    OrderingService {

    private val orderingRetrofitService: OrderingRetrofitService =
        retrofit.create(OrderingRetrofitService::class.java)

    override fun getCategories(locationId: Int, callback: Callback<OrderCategoriesResponse>): CancellableTask {
        val getCategoriesCall = orderingRetrofitService.getCategories(authToken, "no-cache", bizId, locationId)
        getCategoriesCall.clone().enqueue(callback)
        return CancellableTaskWrapper(getCategoriesCall)
    }

    override fun getItems(
        categoryId: Int, locationId: String, offset: Int, limit: Int, callback: Callback<CartItemResponse>
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
        categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int
        , callback: Callback<CartItemResponse>
    ): CancellableTask {
        val getFilteredItemsCall =
            orderingRetrofitService.getFilteredItems(authToken, categoryId, locationId, filterBy, bizId, offset, limit)
        getFilteredItemsCall.clone().enqueue(callback)
        return CancellableTaskWrapper(getFilteredItemsCall)
    }

    override fun getSortByItems(
        categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int
        , callback: Callback<CartItemResponse>
    ): CancellableTask {
        val getFilteredItemsCall =
            orderingRetrofitService.getSortedItems(authToken, categoryId, locationId, sortBy, bizId, offset, limit)
        getFilteredItemsCall.clone().enqueue(callback)
        return CancellableTaskWrapper(getFilteredItemsCall)
    }

    override fun getFeaturedItems(locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask {
        val featuredItems = orderingRetrofitService.getFeaturedItems(authToken, locationId)
        featuredItems.clone().enqueue(callback)
        return CancellableTaskWrapper(featuredItems)
    }

    override fun getRecommendedItems(
        itemId: String, locationId: Int, callback: Callback<RecommendedItemResponse>
    ): CancellableTask {
        val recommendedItems = orderingRetrofitService.getRecommendedItems(authToken, itemId, locationId)
        recommendedItems.clone().enqueue(callback)
        return CancellableTaskWrapper(recommendedItems)
    }

    override fun getItemDetails(
        itemId: Int, locationId: Int, cacheBuster: Long, callback: Callback<OrderItemResponse>
    ): CancellableTask {
        val itemDetailsCall = orderingRetrofitService.getItemDetails(authToken, itemId, locationId, cacheBuster)
        itemDetailsCall.clone().enqueue(callback)
        return CancellableTaskWrapper(itemDetailsCall)
    }

    override fun searchItems(
        keyword: String, locationId: Int, callback: Callback<OrderItemsSearchResponse>
    ): CancellableTask {
        val searchItems = orderingRetrofitService.searchItems(authToken, keyword, locationId)
        searchItems.clone().enqueue(callback)
        return CancellableTaskWrapper(searchItems)
    }


}