[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientDefault](index.md) / [unLikeItem](./un-like-item.md)

# unLikeItem

`fun unLikeItem(itemId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`Like`](../../com.urbanpiper.upsdk.model.networkresponse/-like/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [UserService.unLikeItem](../-user-service/un-like-item.md)

This method un likes an item based on the item id

### Parameters

`itemId` -
* Item id

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun unLikeItem(itemId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`Like`](../../com.urbanpiper.upsdk.model.networkresponse/-like/index.md)`>`

Overrides [UserService.unLikeItem](../-user-service/un-like-item.md)

This method un likes an item based on the item id

### Parameters

`itemId` -
* Item id

**Return**
Observable - the result of the network request is returned as an Observable

