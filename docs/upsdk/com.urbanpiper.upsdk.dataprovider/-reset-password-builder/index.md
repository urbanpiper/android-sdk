[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [ResetPasswordBuilder](./index.md)

# ResetPasswordBuilder

`class ResetPasswordBuilder`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ResetPasswordBuilder(userServiceDefault: `[`UserServiceDefault`](../-user-service-default/index.md)`)` |

### Functions

| Name | Summary |
|---|---|
| [resetPassword](reset-password.md) | `fun resetPassword(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, newPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, confirmPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, otp: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`GenericResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-generic-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`fun resetPassword(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, newPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, confirmPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, otp: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`GenericResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-generic-response/index.md)`>`<br>This method reset's the password after the user enter's the password reset otp sent through SMS and email |
| [sendResetPasswordOTP](send-reset-password-o-t-p.md) | `fun sendResetPasswordOTP(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`GenericResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-generic-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`fun sendResetPasswordOTP(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`GenericResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-generic-response/index.md)`>`<br>This method generates a password reset token that is sent to the user through SMS and phone |
