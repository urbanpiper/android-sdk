[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserService](index.md) / [likeItem](./like-item.md)

# likeItem

`abstract fun likeItem(itemId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`Like`](../../com.urbanpiper.upsdk.model.networkresponse/-like/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This method likes an item based on the item id

### Parameters

`itemId` -
* Item id

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun likeItem(itemId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`Like`](../../com.urbanpiper.upsdk.model.networkresponse/-like/index.md)`>`

This method likes an item based on the item id

### Parameters

`itemId` -
* Item id

**Return**
Observable - the result of the network request is returned as an Observable

