[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientDefault](index.md) / [getUserLikes](./get-user-likes.md)

# getUserLikes

`fun getUserLikes(ids: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`UserLikesResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-likes-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [UserService.getUserLikes](../-user-service/get-user-likes.md)

Returns a list of likes for item id's passed as (eg - id1,id2,id3)

### Parameters

`ids` -
* Item id's passed as a comma separated values (eg - id1,id2,id3)

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getUserLikes(ids: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`UserLikesResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-likes-response/index.md)`>`

Overrides [UserService.getUserLikes](../-user-service/get-user-likes.md)

Returns a list of likes for item id's passed as (eg - id1,id2,id3)

### Parameters

`ids` -
* Item id's passed as a comma separated values (eg - id1,id2,id3)

**Return**
Observable - the result of the network request is returned as an Observable

