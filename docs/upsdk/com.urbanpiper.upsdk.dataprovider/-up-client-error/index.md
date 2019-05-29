[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UpClientError](./index.md)

# UpClientError

`class UpClientError`

This class returns network errors

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `UpClientError(retrofitErrorThrowable: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?)`<br>This class returns network errors |

### Properties

| Name | Summary |
|---|---|
| [ERROR_TYPE_API](-e-r-r-o-r_-t-y-p-e_-a-p-i.md) | `val ERROR_TYPE_API: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Represents any errors returning from the backend |
| [ERROR_TYPE_NETWORK](-e-r-r-o-r_-t-y-p-e_-n-e-t-w-o-r-k.md) | `val ERROR_TYPE_NETWORK: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Represents any network related errors |
| [ERROR_TYPE_UNKNOWN](-e-r-r-o-r_-t-y-p-e_-u-n-k-n-o-w-n.md) | `val ERROR_TYPE_UNKNOWN: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Represent any unknown errors |

### Functions

| Name | Summary |
|---|---|
| [getErrorType](get-error-type.md) | `fun getErrorType(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Returns the different types of errors |
| [getResponseCode](get-response-code.md) | `fun getResponseCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>This returns a -1 if the error is because of an IOException, only http errors are returned |
| [getResponseMessage](get-response-message.md) | `fun getResponseMessage(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This returns the response error message |
| [getThrowable](get-throwable.md) | `fun getThrowable(): `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`?` |
| [isSessionExpired](is-session-expired.md) | `fun isSessionExpired(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>This method shows whether or not the session has expired i.e - The if the token has expired and an API returns a 401 |
