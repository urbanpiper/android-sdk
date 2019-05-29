[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserService](index.md) / [updateUserInfo](./update-user-info.md)

# updateUserInfo

`abstract fun updateUserInfo(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, body: `[`UpdateUserInfoBody`](../../com.urbanpiper.upsdk.model/-update-user-info-body/index.md)`, callback: `[`Callback`](../-callback/index.md)`<`[`UpdateUserInfoResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-update-user-info-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Updates the profile data associated with a particular user identified by the phone number.

### Parameters

`phone` -
* Phone number

`body` -
* UpdateUserInfo Object

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun updateUserInfo(phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, body: `[`UpdateUserInfoBody`](../../com.urbanpiper.upsdk.model/-update-user-info-body/index.md)`): Observable<`[`UpdateUserInfoResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-update-user-info-response/index.md)`>`

Updates the profile data associated with a particular user identified by the phone number.

### Parameters

`phone` -
* Phone number

`body` -
* UpdateUserInfo Object

**Return**
Observable - the result of the network request is returned as an Observable

