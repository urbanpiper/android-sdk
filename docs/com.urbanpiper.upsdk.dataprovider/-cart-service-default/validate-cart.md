[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartServiceDefault](index.md) / [validateCart](./validate-cart.md)

# validateCart

`fun validateCart(order: `[`Order`](../../com.urbanpiper.upsdk.model/-order/index.md)`, callback: `[`Callback`](../-callback/index.md)`<`[`ValidateCartResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-validate-cart-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This is an important method in the flow of placing an order. This endpoint validates the contents
of the cart to return the computational details for the order, like the charges, taxes, total, etc.
We strongly recommend client applications not to perform these complex computations at their end,
since there are many variables that can affect the computations—not all of which are available with
the client application at any time.

### Parameters

`order` -
* Order object

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun validateCart(order: `[`Order`](../../com.urbanpiper.upsdk.model/-order/index.md)`): Observable<`[`ValidateCartResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-validate-cart-response/index.md)`>`

This is an important method in the flow of placing an order. This endpoint validates the contents
of the cart to return the computational details for the order, like the charges, taxes, total, etc.
We strongly recommend client applications not to perform these complex computations at their end,
since there are many variables that can affect the computations—not all of which are available with
the client application at any time.

### Parameters

`order` -
* Order object

**Return**
Observable - the result of the network request is returned as an Observable

