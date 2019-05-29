[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserService](index.md) / [changePassword](./change-password.md)

# changePassword

`abstract fun changePassword(oldPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, newPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, confirmPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`GenericResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-generic-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Change the password for a user, The new password has to be passed in twice so the server can
verify it

### Parameters

`oldPassword` -
* Old password

`newPassword` -
* New password

`confirmPassword` -
* New password

`phone` -
* phone number

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun changePassword(oldPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, newPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, confirmPassword: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`GenericResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-generic-response/index.md)`>`

Change the password for a user, The new password has to be passed in twice so the server can
verify it

### Parameters

`oldPassword` -
* Old password

`newPassword` -
* New password

`confirmPassword` -
* New password

`phone` -
* phone number

**Return**
Observable - the result of the network request is returned as an Observable

