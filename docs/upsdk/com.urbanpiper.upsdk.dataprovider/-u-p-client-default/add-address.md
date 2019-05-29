[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientDefault](index.md) / [addAddress](./add-address.md)

# addAddress

`fun addAddress(userAddress: `[`UserAddress`](../../com.urbanpiper.upsdk.model.networkresponse/-user-address/index.md)`, callback: `[`Callback`](../-callback/index.md)`<`[`UserAddressSaveResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-address-save-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [UserService.addAddress](../-user-service/add-address.md)

This method adds a new address for the user

### Parameters

`userAddress` -
* UserAddress Object

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun addAddress(userAddress: `[`UserAddress`](../../com.urbanpiper.upsdk.model.networkresponse/-user-address/index.md)`): Observable<`[`UserAddressSaveResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-address-save-response/index.md)`>`

Overrides [UserService.addAddress](../-user-service/add-address.md)

This method adds a new address for the user

### Parameters

`userAddress` -
* UserAddress Object

**Return**
Observable - the result of the network request is returned as an Observable

