package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class CatalogueServiceDefault(private val authToken: String, private val bizId: String, retrofit: Retrofit) :
    CatalogueService {

    private val orderingRetrofitService: CatalogueRetrofitService =
        retrofit.create(CatalogueRetrofitService::class.java)

    /**
     * Get all the categories
     */
    override fun getCategories(locationId: Int, callback: Callback<CategoriesResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getCategories(locationId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )
        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Get all the categories
     */
    override fun getCategories(locationId: Int): Observable<CategoriesResponse> {
        return orderingRetrofitService.getCategories(authToken, "no-cache", bizId, locationId)
    }

    /**
     * Get items for a particular category
     */
    override fun getCategoryItems(
        categoryId: Int, locationId: String, offset: Int, limit: Int, callback: Callback<CategoryItemResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getCategoryItems(categoryId, locationId, offset, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )

        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Get items for a particular category
     */
    override fun getCategoryItems(
        categoryId: Int, locationId: String, offset: Int, limit: Int
    ): Observable<CategoryItemResponse> {
        return orderingRetrofitService.getCategoryItems(authToken, categoryId, locationId, bizId, offset, limit)
    }

    /**
     * Get filter and sort options for a particular category
     */
    override fun getFilterAndSortOptions(
        categoryId: Int, callback: Callback<FilterAndSortOptionsResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getFilterAndSortOptions(categoryId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )

        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Get filter and sort options for a particular category
     */
    override fun getFilterAndSortOptions(categoryId: Int): Observable<FilterAndSortOptionsResponse> {
        return orderingRetrofitService.getFilterSortOptions(authToken, categoryId)
    }

    /**
     * Get filtered items for a particular category
     */
    override fun getFilteredItems(
        categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int,
        callback: Callback<CategoryItemResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getFilteredItems(categoryId, locationId, filterBy, offset, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )

        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Get filtered items for a particular category
     */
    override fun getFilteredItems(
        categoryId: Int, locationId: String, filterBy: String, offset: Int, limit: Int
    ): Observable<CategoryItemResponse> {
        return orderingRetrofitService.getFilteredItems(
            authToken, categoryId, locationId, filterBy, bizId, offset, limit
        )
    }

    /**
     * Get sorted items for a particular category
     */
    override fun getSortedItems(
        categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int,
        callback: Callback<CategoryItemResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getSortedItems(categoryId, locationId, sortBy, offset, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )

        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Get sorted items for a particular category
     */
    override fun getSortedItems(
        categoryId: Int, locationId: String, sortBy: String, offset: Int, limit: Int
    ): Observable<CategoryItemResponse> {
        return orderingRetrofitService.getSortedItems(authToken, categoryId, locationId, sortBy, bizId, offset, limit)
    }

    /**
     * Get recommended items
     */
    override fun getRecommendedItems(locationId: Int, callback: Callback<RecommendedItemResponse>): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getRecommendedItems(locationId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )

        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Get recommended items
     */
    override fun getRecommendedItems(locationId: Int): Observable<RecommendedItemResponse> {
        return orderingRetrofitService.getRecommendedItems(authToken, locationId)
    }

    /**
     * Get Related items
     */
    override fun getRelatedItems(
        itemId: String, locationId: Int, callback: Callback<RecommendedItemResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getRelatedItems(itemId, locationId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )

        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Get Related items
     */
    override fun getRelatedItems(itemId: String, locationId: Int): Observable<RecommendedItemResponse> {
        return orderingRetrofitService.getRelatedItems(authToken, itemId, locationId)
    }

    /**
     * Get Item Details
     */
    override fun getItemDetails(
        itemId: Int, locationId: Int, callback: Callback<ItemDetailsResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            getItemDetails(itemId, locationId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )

        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Get Item Details
     */
    override fun getItemDetails(itemId: Int, locationId: Int): Observable<ItemDetailsResponse> {
        return orderingRetrofitService.getItemDetails(authToken, itemId, locationId)
    }

    /**
     * Search for items
     */
    override fun searchItems(
        query: String, locationId: Int, callback: Callback<CategorySearchResponse>
    ): CancellableTask {
        val compositeDisposable = CompositeDisposable()

        compositeDisposable.add(
            searchItems(query, locationId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ success ->
                    callback.success(success)
                }, { error ->
                    callback.failure(UpClientError(error))
                })
        )

        return CancellableTaskDisposableWrapper(compositeDisposable)
    }

    /**
     * Search for items
     */
    override fun searchItems(query: String, locationId: Int): Observable<CategorySearchResponse> {
        return orderingRetrofitService.searchItems(authToken, query, locationId)
    }

}