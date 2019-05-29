[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientDefault](index.md) / [getSortedItems](./get-sorted-items.md)

# getSortedItems

`fun getSortedItems(categoryId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sortBy: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`CategoryItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-category-item-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [CatalogueService.getSortedItems](../-catalogue-service/get-sorted-items.md)

returns a list of active items sorted based on the sort option passed

returns a list of active items sorted based on the sort option received
from the getFilterAndSortOptions method for a category from which an order can be placed.
Only a single sort option can be passed.

### Parameters

`categoryId` -
* Category Id

`locationId` -
* Location Id

`sortBy` -
* Sort option

`offset` -
* offset

`limit` -
* limit

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getSortedItems(categoryId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sortBy: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`CategoryItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-category-item-response/index.md)`>`

Overrides [CatalogueService.getSortedItems](../-catalogue-service/get-sorted-items.md)

returns a list of active items sorted based on the sort option passed

returns a list of active items sorted based on the sort option received
from the getFilterAndSortOptions method for a category from which an order can be placed.
Only a single sort option can be passed.

### Parameters

`categoryId` -
* Category Id

`locationId` -
* Location Id

`sortBy` -
* Sort option

`offset` -
* offset

`limit` -
* limit

**Return**
Observable - the result of the network request is returned as an Observable

