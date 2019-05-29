[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [CartRetrofitService](index.md) / [initPayment](./init-payment.md)

# initPayment

`@GET("/payments/init/{biz_id}/{store_id}/?channel=app_android") abstract fun initPayment(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("biz_id") bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("store_id") storeId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, @Query("amount") amount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, @Query("purpose") purpose: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("redirect_url") redirectUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Query("paytm") paytm: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, @Query("simpl") simpl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): Observable<`[`PaymentInitResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-payment-init-response/index.md)`>`

Initiates a payment for the particular biz's store. This is useful if the biz is
using a franchisee model.

### Parameters

`bizId` -

`storeId` -

`authToken` -

`amount` -

`purpose` -
* can be either or `ordering`/`reload`
