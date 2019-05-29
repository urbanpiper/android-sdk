[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserServiceDefault](index.md) / [sendResetPasswordOTP](./send-reset-password-o-t-p.md)

# sendResetPasswordOTP

`fun sendResetPasswordOTP(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`GenericResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-generic-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This method generates a password reset token that is sent to the user through
SMS and phone

### Parameters

`phone` -
* Phone number

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun sendResetPasswordOTP(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`GenericResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-generic-response/index.md)`>`

This method generates a password reset token that is sent to the user through
SMS and phone

### Parameters

`phone` -
* Phone number

**Return**
Observable - the result of the network request is returned as an Observable

