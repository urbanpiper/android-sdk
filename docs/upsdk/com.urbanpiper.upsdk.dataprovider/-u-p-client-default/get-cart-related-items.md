[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientDefault](index.md) / [getCartRelatedItems](./get-cart-related-items.md)

# getCartRelatedItems

`fun getCartRelatedItems(itemIds: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`RecommendedItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-recommended-item-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [CartService.getCartRelatedItems](../-cart-service/get-cart-related-items.md)

returns a list of items which are sent based on the location id and other items
Multiple item id's can be passed as comma separated values Eg( id1,id2,id3 )

### Parameters

`itemIds` -
* Item id

`locationId` -
* Location id

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getCartRelatedItems(itemIds: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`RecommendedItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-recommended-item-response/index.md)`>`

Overrides [CartService.getCartRelatedItems](../-cart-service/get-cart-related-items.md)

returns a list of items which are sent based on the location id and other items
Multiple item id's can be passed as comma separated values Eg( id1,id2,id3 )

### Parameters

`itemIds` -
* Item id

`locationId` -
* Location id

**Return**
Observable - the result of the network request is returned as an Observable

