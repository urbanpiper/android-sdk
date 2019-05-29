[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartServiceDefault](index.md) / [getCartRelatedItems](./get-cart-related-items.md)

# getCartRelatedItems

`fun getCartRelatedItems(itemIds: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`RecommendedItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-recommended-item-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [CartService.getCartRelatedItems](../-cart-service/get-cart-related-items.md)

Get the recommended items from the server. The items returned are based on a particular item
in details or checkout page.

### Parameters

`itemIds` -
* Item id's can be passed as comma separated values (id1,id2,id3)

`locationId` -
* Location id of the user

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getCartRelatedItems(itemIds: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locationId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`RecommendedItemResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-recommended-item-response/index.md)`>`

Overrides [CartService.getCartRelatedItems](../-cart-service/get-cart-related-items.md)

Get the recommended items from the server. The items returned are based on a particular item
in details or checkout page.

### Parameters

`itemIds` -
* Item id's can be passed as comma separated values (id1,id2,id3)

`locationId` -
* Location id of the user

**Return**
Observable - the result of the network request is returned as an Observable

