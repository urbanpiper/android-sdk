[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CatalogueServiceDefault](index.md) / [getRecommendedItems](./get-recommended-items.md)

# getRecommendedItems

`fun getRecommendedItems(locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`RecommendedItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-recommended-item-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [CatalogueService.getRecommendedItems](../-catalogue-service/get-recommended-items.md)

returns a list of active recommended items which are sent based on the location id (based on the store)

### Parameters

`locationId` -
* location id

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getRecommendedItems(locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`RecommendedItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-recommended-item-response/index.md)`>`

Overrides [CatalogueService.getRecommendedItems](../-catalogue-service/get-recommended-items.md)

returns a list of active recommended items which are sent based on the location id (based on the store)

### Parameters

`locationId` -
* location id

**Return**
Observable - the result of the network request is returned as an Observable

