[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [Callback](./index.md)

# Callback

`interface Callback<T>`

This callback returns the response from a network call

success - Returns the success response from the network call, if it succeeded
failure - Returns an error from the network call, if it failed

### Parameters

`T` -
* Type of network response

### Functions

| Name | Summary |
|---|---|
| [failure](failure.md) | `abstract fun failure(upClientError: `[`UpClientError`](../-up-client-error/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [success](success.md) | `abstract fun success(response: `[`T`](index.md#T)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
