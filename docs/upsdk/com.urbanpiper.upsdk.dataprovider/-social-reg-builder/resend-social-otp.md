[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [SocialRegBuilder](index.md) / [resendSocialOtp](./resend-social-otp.md)

# resendSocialOtp

`fun resendSocialOtp(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Resend Social OTP

### Parameters

`email` -
* Email

`phone` -
* Phone

`provider` -
* Provider

`accessToken` -
* Access Token for google / facebook

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun resendSocialOtp(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, provider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, accessToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`SocialAuthResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-social-auth-response/index.md)`>`

Resend Social OTP

### Parameters

`email` -
* Email

`phone` -
* Phone

`provider` -
* Provider

`accessToken` -
* Access Token for google / facebook
