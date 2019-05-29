[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartServiceDefault](index.md) / [reOrder](./re-order.md)

# reOrder

`fun reOrder(orderId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lat: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lng: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`ReOrderResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-re-order-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [CartService.reOrder](../-cart-service/re-order.md)

Re order Api

### Parameters

`orderId` -
* Id of the order

`locationId` -
* location id of the user

`lat` -
* latitude

`lng` -
* longitude

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun reOrder(orderId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lat: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lng: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`ReOrderResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-re-order-response/index.md)`>`

Overrides [CartService.reOrder](../-cart-service/re-order.md)

Re order api

### Parameters

`orderId` -
* Id of the order

`locationId` -
* location id of the user

`lat` -
* latitude

`lng` -
* longitude

**Return**
Observable - the result of the network request is returned as an Observable

