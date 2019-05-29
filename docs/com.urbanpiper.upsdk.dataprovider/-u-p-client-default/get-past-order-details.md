[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientDefault](index.md) / [getPastOrderDetails](./get-past-order-details.md)

# getPastOrderDetails

`fun getPastOrderDetails(orderId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`OrderDetailResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-detail-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [UserService.getPastOrderDetails](../-user-service/get-past-order-details.md)

Returns details information about an order

### Parameters

`orderId` -
* Order id

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getPastOrderDetails(orderId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`OrderDetailResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-detail-response/index.md)`>`

Overrides [UserService.getPastOrderDetails](../-user-service/get-past-order-details.md)

Returns details information about an order

### Parameters

`orderId` -
* Order id

**Return**
Observable - the result of the network request is returned as an Observable

