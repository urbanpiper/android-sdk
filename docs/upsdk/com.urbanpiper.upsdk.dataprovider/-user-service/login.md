[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserService](index.md) / [login](./login.md)

# login

`abstract fun login(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`AuthSuccessResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-auth-success-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

For login the user needs to provide his/her phone number, along with the password
that they had set for their account.

### Parameters

`phone` -
* Phone number of the user

`password` -
* User password

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun login(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`AuthSuccessResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-auth-success-response/index.md)`>`

For login the user needs to provide his/her phone number, along with the password
that they had set for their account.

### Parameters

`phone` -
* Phone number of the user

`password` -
* User password

**Return**
Observable - the result of the network request is returned as an Observable

