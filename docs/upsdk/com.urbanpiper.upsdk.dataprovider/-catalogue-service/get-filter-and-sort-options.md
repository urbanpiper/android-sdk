[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CatalogueService](index.md) / [getFilterAndSortOptions](./get-filter-and-sort-options.md)

# getFilterAndSortOptions

`abstract fun getFilterAndSortOptions(categoryId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`FilterAndSortOptionsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-filter-and-sort-options-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This endpoint handles requests to get available filter and sort options for a category.

### Parameters

`categoryId` -
* Category Id

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun getFilterAndSortOptions(categoryId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`FilterAndSortOptionsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-filter-and-sort-options-response/index.md)`>`

This endpoint handles requests to get available filter and sort options for a category.

### Parameters

`categoryId` -
* Category Id

**Return**
Observable - the result of the network request is returned as an Observable

