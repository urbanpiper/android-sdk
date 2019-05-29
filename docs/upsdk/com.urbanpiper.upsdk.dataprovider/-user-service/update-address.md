[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserService](index.md) / [updateAddress](./update-address.md)

# updateAddress

`abstract fun updateAddress(userAddress: `[`UserAddress`](../../com.urbanpiper.upsdk.model.networkresponse/-user-address/index.md)`, callback: `[`Callback`](../-callback/index.md)`<`[`UserAddressSaveResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-address-save-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This method adds a updates an existing address for the user

### Parameters

`userAddress` -
* UserAddress Object

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun updateAddress(userAddress: `[`UserAddress`](../../com.urbanpiper.upsdk.model.networkresponse/-user-address/index.md)`): Observable<`[`UserAddressSaveResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-address-save-response/index.md)`>`

This method adds a updates an existing address for the user

### Parameters

`userAddress` -
* UserAddress Object

**Return**
Observable - the result of the network request is returned as an Observable

