[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserService](index.md) / [refreshToken](./refresh-token.md)

# refreshToken

`abstract fun refreshToken(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`AuthSuccessResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-auth-success-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

We use JWT tokens for authentication, we need to use this method to get a new token
if the current token has completed 80% of it's lifetime

### Parameters

`token` -
* Old token

`callback` -
* Callback to receive the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun refreshToken(token: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`AuthSuccessResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-auth-success-response/index.md)`>`

We use JWT tokens for authentication, we need to use this method to get a new token
if the current token has completed 80% of it's lifetime

### Parameters

`token` -
* Old token

**Return**
Observable - the result of the network request is returned as an Observable

