[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CatalogueService](index.md) / [getCategories](./get-categories.md)

# getCategories

`abstract fun getCategories(locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`CategoriesResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-categories-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

returns a list of active categories of items from which an order can be placed

This method returns the list of active categories of items from which an order can be placed.

### Parameters

`locationId` -
* Location id is returned from the store

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun getCategories(locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`CategoriesResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-categories-response/index.md)`>`

returns a list of active categories of items from which an order can be placed

This method returns the list of active categories of items from which an order can be placed.

### Parameters

`locationId` -
* Location id is returned from the store

**Return**
Observable - the result of the network request is returned as an Observable

