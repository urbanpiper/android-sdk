[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [getResetPasswordToken](./get-reset-password-token.md)

# getResetPasswordToken

`@POST("/api/v1/user/password/token/") abstract fun getResetPasswordToken(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Body body: `[`ForgotPwdGenerateTokenReq`](../../com.urbanpiper.upsdk.model.networkresponse/-forgot-pwd-generate-token-req/index.md)`): Observable<`[`GenericResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-generic-response/index.md)`>`

Generate a token for forgot password

### Parameters

`authToken` -

`body` - 