[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserService](index.md) / [socialLogin](./social-login.md)

# socialLogin

`abstract fun socialLogin(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Login to the using social auth providers (eg, Facebook, Google)

### Parameters

`email` -

`provider` -

`accessToken` -

`callback` -

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun socialLogin(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>`

Login to the using social auth providers (eg, Facebook, Google)

### Parameters

`email` -

`provider` -

`accessToken` -

**Return**
Observable - the result of the network request is returned as an Observable

