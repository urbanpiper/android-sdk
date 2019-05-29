[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [GeneralServiceDefault](index.md) / [getAllStores](./get-all-stores.md)

# getAllStores

`fun getAllStores(callback: `[`Callback`](../-callback/index.md)`<`[`StoreListResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-list-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [GeneralService.getAllStores](../-general-service/get-all-stores.md)

Returns all the stores for the business

This method returns all the stores configured for a business.

### Parameters

`callback` -
* Callback to receive the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getAllStores(): Observable<`[`StoreListResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-list-response/index.md)`>`

Overrides [GeneralService.getAllStores](../-general-service/get-all-stores.md)

Returns all the stores for the business

This method returns all the stores configured for a business.

**Return**
Observable - the result of the network request is returned as an Observable

