[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [ResetPasswordBuilder](index.md) / [resetPassword](./reset-password.md)

# resetPassword

`fun resetPassword(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, newPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, confirmPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, otp: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`GenericResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-generic-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This method reset's the password after the user enter's the password reset otp sent
through SMS and email

The password has to be sent twice so that the server can verify it

### Parameters

`phone` -
* Phone number

`newPassword` -
* New password

`confirmPassword` -
* Confirm same password

`otp` -
* OTP the user input's

`callback` -
* Callback to return the result

**Return**
Observable - the result of the network request is returned as an Observable

`fun resetPassword(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, newPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, confirmPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, otp: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`GenericResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-generic-response/index.md)`>`

This method reset's the password after the user enter's the password reset otp sent
through SMS and email

The password has to be sent twice so that the server can verify it

### Parameters

`phone` -
* Phone number

`newPassword` -
* New password

`confirmPassword` -
* Confirm same password

`otp` -
* Token the user input's

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

