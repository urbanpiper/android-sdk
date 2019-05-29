[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientDefault](index.md) / [getFilteredItems](./get-filtered-items.md)

# getFilteredItems

`fun getFilteredItems(categoryId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, filterBy: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`CategoryItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-category-item-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [CatalogueService.getFilteredItems](../-catalogue-service/get-filtered-items.md)

returns a list of active items filtered based on the filters passed

This method returns a list of active items filtered based on filters received
from the getFilterAndSortOptions method for a category from which an order can be placed.
Multiple filters can be sent as comma separated values (eg - filter1,filter2,filter3)

### Parameters

`categoryId` -
* Category Id

`locationId` -
* Location Id

`filterBy` -
* Filter received from getFilterAndSortOptions methods

`offset` -
* offset

`limit` -
* limit

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getFilteredItems(categoryId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, filterBy: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, limit: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`CategoryItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-category-item-response/index.md)`>`

Overrides [CatalogueService.getFilteredItems](../-catalogue-service/get-filtered-items.md)

returns a list of active items filtered based on the filters passed

This method returns a list of active items filtered based on filters received
from the getFilterAndSortOptions method for a category from which an order can be placed.
Multiple filters can be sent as comma separated values (eg - filter1,filter2,filter3)

### Parameters

`categoryId` -
* Category Id

`locationId` -
* Location Id

`filterBy` -
* Filter received from getFilterAndSortOptions methods

`offset` -
* offset

`limit` -
* limit

**Return**
Observable - the result of the network request is returned as an Observable

