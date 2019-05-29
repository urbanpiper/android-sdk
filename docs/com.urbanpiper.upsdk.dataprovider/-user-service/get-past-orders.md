[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserService](index.md) / [getPastOrders](./get-past-orders.md)

# getPastOrders

`abstract fun getPastOrders(callback: `[`Callback`](../-callback/index.md)`<`[`OrderHistoryResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-history-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This endpoint returns the list of orders placed by a user in the past. Only the summary data
for each order is returned. This should be used when a client needs to display the past orders placed
by a user.

### Parameters

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun getPastOrders(): Observable<`[`OrderHistoryResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-order-history-response/index.md)`>`

This endpoint returns the list of orders placed by a user in the past. Only the summary data
for each order is returned. This should be used when a client needs to display the past orders placed
by a user.

**Return**
Observable - the result of the network request is returned as an Observable

