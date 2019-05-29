[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [SocialRegBuilder](index.md) / [resendRegOTP](./resend-reg-o-t-p.md)

# resendRegOTP

`fun resendRegOTP(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`RegistrationResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-registration-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This method is used ot resend the OTP

### Parameters

`phone` -
* Phone number

`callback` -
* callback to return the result
`fun resendRegOTP(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`RegistrationResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-registration-response/index.md)`>`

This method is used to resend the OTP

### Parameters

`phone` -
* Phone number
