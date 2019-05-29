[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserRetrofitService](index.md) / [redeemReward](./redeem-reward.md)

# redeemReward

`@POST("/api/v2/rewards/{rewards_id}/redeem/") abstract fun redeemReward(@Header("Authorization") authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, @Path("rewards_id") rewardId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, @Body blank: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`RedeemRewardResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-redeem-reward-response/index.md)`>`

Redeem a reward

