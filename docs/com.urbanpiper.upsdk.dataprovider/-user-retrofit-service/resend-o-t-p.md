[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [resendOTP](./resend-o-t-p.md)

# resendOTP

`@POST("/api/v2/card/?pin=resendotp") abstract fun resendOTP(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("customer_phone") phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`RegistrationResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-registration-response/index.md)`>`

Resend OTP

### Parameters

`authToken` -
* Auth token

`body` -
* Object of verify OTP body , No need to send HTTP Body
