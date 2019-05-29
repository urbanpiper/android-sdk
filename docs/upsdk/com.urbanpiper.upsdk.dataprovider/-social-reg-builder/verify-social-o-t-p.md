[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [SocialRegBuilder](index.md) / [verifySocialOTP](./verify-social-o-t-p.md)

# verifySocialOTP

`fun verifySocialOTP(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, action: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, otp: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Resend Social login OTP

### Parameters

`email` -
* email

`provider` -
* provider

`accessToken` -
* accessToken

`action` -
* action

`phone` -
* phone

`otp` -
* otp

`callback` -
* Callback to return the result

**Return**
Observable - the result of the network request is returned as an Observable

`fun verifySocialOTP(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, action: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, otp: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>`

Verifies Social Login OTP

### Parameters

`email` -
* email

`provider` -
* provider

`accessToken` -
* accessToken

`action` -
* action

`phone` -
* phone

`otp` -
* otp
