[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientDefault](index.md) / [socialLogin](./social-login.md)

# socialLogin

`fun socialLogin(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [UserService.socialLogin](../-user-service/social-login.md)

Login using social auth providers (eg. google, facebook)

### Parameters

`email` -
* email address of the user

`provider` -
* provider (google/facebook)

`accessToken` -
* access token from google/facebook

`callback` -
* Callback to receive the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun socialLogin(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>`

Overrides [UserService.socialLogin](../-user-service/social-login.md)

Login using social auth providers (eg. google, facebook)

### Parameters

`email` -
* email address of the user

`provider` -
* provider (google/facebook)

`accessToken` -
* access token from google/facebook

**Return**
Observable - the result of the network request is returned as an Observable

