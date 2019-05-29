[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [refreshToken](./refresh-token.md)

# refreshToken

`@POST("/api/v2/auth/refresh-token/") abstract fun refreshToken(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Body body: `[`JWTRefreshTokenBody`](../../com.urbanpiper.upsdk.model/-j-w-t-refresh-token-body/index.md)`): Observable<`[`AuthSuccessResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-auth-success-response/index.md)`>`

Observable to refresh the JWT token

### Parameters

`authToken` -
* biz auth token

`body` -
*
