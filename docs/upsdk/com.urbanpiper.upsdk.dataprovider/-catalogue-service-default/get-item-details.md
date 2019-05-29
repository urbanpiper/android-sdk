[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CatalogueServiceDefault](index.md) / [getItemDetails](./get-item-details.md)

# getItemDetails

`fun getItemDetails(itemId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`ItemDetailsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-item-details-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [CatalogueService.getItemDetails](../-catalogue-service/get-item-details.md)

This method returns detailed information for a particular ordering item

### Parameters

`itemId` -
* Item id

`locationId` -
* Location id

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getItemDetails(itemId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`ItemDetailsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-item-details-response/index.md)`>`

Overrides [CatalogueService.getItemDetails](../-catalogue-service/get-item-details.md)

This method returns detailed information for a particular ordering item

### Parameters

`itemId` -
* Item id

`locationId` -
* Location id

**Return**
Observable - the result of the network request is returned as an Observable

