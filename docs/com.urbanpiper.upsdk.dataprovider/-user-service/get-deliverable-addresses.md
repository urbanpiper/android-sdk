[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserService](index.md) / [getDeliverableAddresses](./get-deliverable-addresses.md)

# getDeliverableAddresses

`abstract fun getDeliverableAddresses(locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`DeliverableAddressResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-deliverable-address-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This method returns a list of addresses for a given location idm
with a field deliverable(true or false) indicating if delivery is possible for that location or not

### Parameters

`locationId` -
* Location id

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun getDeliverableAddresses(locationId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`DeliverableAddressResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-deliverable-address-response/index.md)`>`

This method returns a list of addresses for a given location id
with a field deliverable(true or false) indicating if delivery is possible for that location or not

### Parameters

`locationId` -
* Location id

**Return**
Observable - the result of the network request is returned as an Observable

