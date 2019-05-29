[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [GeneralService](index.md) / [getNearestStore](./get-nearest-store.md)

# getNearestStore

`abstract fun getNearestStore(lat: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lng: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`StoreResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Returns the nearest store based on lat/ lng

This endpoint helps determine the nearest store from which an order can be delivered.
It expects the latitude/longitude information of the location to be delivered to.
Along with the store information, this endpoint also returns the biz related information,
which can be cached for later use.

### Parameters

`lat` -
* User's latitude

`lng` -
* User's longitude

`callback` -
* Callback to receive the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun getNearestStore(lat: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`, lng: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): Observable<`[`StoreResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-store-response/index.md)`>`

Returns the nearest store based on lat/ lng

This endpoint helps determine the nearest store from which an order can be delivered.
It expects the latitude/longitude information of the location to be delivered to.
Along with the store information, this endpoint also returns the biz related information,
which can be cached for later use.

### Parameters

`lat` -
* User's latitude

`lng` -
* User's longitude

**Return**
Observable - the result of the network request is returned as an Observable

