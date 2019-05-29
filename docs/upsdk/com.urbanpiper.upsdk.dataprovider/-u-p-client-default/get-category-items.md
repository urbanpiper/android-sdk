[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientDefault](index.md) / [getCategoryItems](./get-category-items.md)

# getCategoryItems

`fun getCategoryItems(categoryId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`CategoryItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-category-item-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [CatalogueService.getCategoryItems](../-catalogue-service/get-category-items.md)

returns a list of active items for a category from which an order can be placed

This endpoint returns the list of active items belonging to a particular category.
This endpoint can find use in scenarios:
When the entire menu for a restaurant is to be displayed.
When the location specific list of items need to be shown for accepting an order.
In this case, the location_id parameter needs to be passed-in.
This is so because the availability for each of the items need to be determined so that customers
don’t place an order for items which might be out of stock.

### Parameters

`categoryId` -
* Category ID

`locationId` -
* Location ID

`offset` -
* offset

`limit` -
* limit

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getCategoryItems(categoryId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`CategoryItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-category-item-response/index.md)`>`

Overrides [CatalogueService.getCategoryItems](../-catalogue-service/get-category-items.md)

returns a list of active items for a category from which an order can be placed

This endpoint returns the list of active items belonging to a particular category.
This endpoint can find use in scenarios:
When the entire menu for a restaurant is to be displayed.
When the location specific list of items need to be shown for accepting an order.
In this case, the location_id parameter needs to be passed-in.
This is so because the availability for each of the items need to be determined so that customers
don’t place an order for items which might be out of stock.

### Parameters

`categoryId` -
* Category ID

`locationId` -
* Location ID

`offset` -
* offset

`limit` -
* limit

**Return**
Observable - the result of the network request is returned as an Observable

