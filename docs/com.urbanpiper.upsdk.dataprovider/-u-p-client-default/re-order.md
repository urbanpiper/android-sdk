[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientDefault](index.md) / [reOrder](./re-order.md)

# reOrder

`fun reOrder(orderId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lat: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lng: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`ReOrderResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-re-order-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [CartService.reOrder](../-cart-service/re-order.md)

This endpoint validates whether a previously placed order can be re-ordered.
The response indicates which items can be re-ordered and which can’t be.

### Parameters

`orderId` -
* Order Id

`locationId` -
* Location Id

`lat` -
* user's current latitude

`lng` -
* user's current longitude

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun reOrder(orderId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lat: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lng: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`ReOrderResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-re-order-response/index.md)`>`

Overrides [CartService.reOrder](../-cart-service/re-order.md)

This endpoint validates whether a previously placed order can be re-ordered.
The response indicates which items can be re-ordered and which can’t be.

### Parameters

`orderId` -
* Order Id

`locationId` -
* Location Id

`lat` -
* user's current latitude

`lng` -
* user's current longitude

**Return**
Observable - the result of the network request is returned as an Observable

