[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartServiceDefault](index.md) / [placeOrder](./place-order.md)

# placeOrder

`fun placeOrder(body: `[`Order`](../../com.urbanpiper.upsdk.model/-order/index.md)`, callback: `[`Callback`](../-callback/index.md)`<`[`OrderSaveResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-save-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Sends the order details to the server

If the payment option is NOT Cash on delivery, a provisional order is placed
order.state = "awaiting_payment"

If the payment option is Cash on Delivery, Then order.state = null

### Parameters

`body` -
* Order object

`callback` -
* callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun placeOrder(body: `[`Order`](../../com.urbanpiper.upsdk.model/-order/index.md)`): Observable<`[`OrderSaveResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-save-response/index.md)`>`

Sends the order details to the server

If the payment option is NOT Cash on delivery, a provisional order is placed
order.state = "awaiting_payment"

If the payment option is Cash on Delivery, Then order.state = null

### Parameters

`body` -
* Order object

**Return**
Observable - the result of the network request is returned as an Observable

