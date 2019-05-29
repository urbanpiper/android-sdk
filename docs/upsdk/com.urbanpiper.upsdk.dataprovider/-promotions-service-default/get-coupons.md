[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [PromotionsServiceDefault](index.md) / [getCoupons](./get-coupons.md)

# getCoupons

`fun getCoupons(callback: `[`Callback`](../-callback/index.md)`<`[`OffersResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-offers-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [PromotionsService.getCoupons](../-promotions-service/get-coupons.md)

This method returns a list of offers that can be applied to an order

### Parameters

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getCoupons(): Observable<`[`OffersResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-offers-response/index.md)`>`

Overrides [PromotionsService.getCoupons](../-promotions-service/get-coupons.md)

This method returns a list of offers that can be applied to an order

**Return**
Observable - the result of the network request is returned as an Observable

