[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UserService](index.md) / [redeemReward](./redeem-reward.md)

# redeemReward

`abstract fun redeemReward(rewardId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, callback: `[`Callback`](../-callback/index.md)`<`[`RedeemRewardResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-redeem-reward-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

This method redeems a reward for a user

### Parameters

`rewardId` -
* Id of the reward

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`abstract fun redeemReward(rewardId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): Observable<`[`RedeemRewardResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-redeem-reward-response/index.md)`>`

This method redeems a reward for a user

### Parameters

`rewardId` -
* Id of the reward

**Return**
Observable - the result of the network request is returned as an Observable

