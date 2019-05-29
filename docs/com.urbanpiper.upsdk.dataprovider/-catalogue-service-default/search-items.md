[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CatalogueServiceDefault](index.md) / [searchItems](./search-items.md)

# searchItems

`fun searchItems(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`CategorySearchResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-category-search-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [CatalogueService.searchItems](../-catalogue-service/search-items.md)

This endpoint handles requests made for searching items in the current inventory.

The text keyword to search is matched against the item’s title,
description and any tags associated with the item.

### Parameters

`query` -
* Keyword

`locationId` -
* Location id

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun searchItems(query: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`CategorySearchResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-category-search-response/index.md)`>`

Overrides [CatalogueService.searchItems](../-catalogue-service/search-items.md)

This endpoint handles requests made for searching items in the current inventory.

The text keyword to search is matched against the item’s title,
description and any tags associated with the item.

### Parameters

`query` -
* Keyword

`locationId` -
* Location id

**Return**
Observable - the result of the network request is returned as an Observable

