[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientBuilder](./index.md)

# UPClientBuilder

`class UPClientBuilder`

Written in java for now

 It would be easier to create the UPClient object if the builder was written in java for third party dev's who might use java to build the android application

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `UPClientBuilder()`<br>Written in java for now <br> It would be easier to create the UPClient object if the builder was written in java for third party dev's who might use java to build the android application |

### Functions

| Name | Summary |
|---|---|
| [build](build.md) | `fun build(): `[`UPClient`](../-u-p-client/index.md) |
| [setApiKey](set-api-key.md) | `fun setApiKey(apiKey: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`UPClientBuilder`](./index.md)<br>Api key |
| [setApiUsername](set-api-username.md) | `fun setApiUsername(apiUserName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`UPClientBuilder`](./index.md)<br>Api Username |
| [setBizId](set-biz-id.md) | `fun setBizId(bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`UPClientBuilder`](./index.md)<br>Biz id - It identifies your business on the UrbanPiper platform <br> Required parameter |
| [setCallback](set-callback.md) | `fun setCallback(callback: `[`Callback`](../-callback/index.md)`<`[`UserBizInfoResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-user-biz-info-response/index.md)`>): `[`UPClientBuilder`](./index.md)<br>Callback that returns user information |
| [setLanguage](set-language.md) | `fun setLanguage(language: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`UPClientBuilder`](./index.md)<br>Language |
