[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [PromotionsServiceDefault](./index.md)

# PromotionsServiceDefault

`class PromotionsServiceDefault : `[`PromotionsService`](../-promotions-service/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PromotionsServiceDefault(bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, retrofit: Retrofit)` |

### Functions

| Name | Summary |
|---|---|
| [getBanners](get-banners.md) | `fun getBanners(callback: `[`Callback`](../-callback/index.md)`<`[`BannerResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-banner-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`fun getBanners(): Observable<`[`BannerResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-banner-response/index.md)`>`<br>The Gallery method returns the list of images that have been uploaded through the configuration portal. |
| [getCoupons](get-coupons.md) | `fun getCoupons(callback: `[`Callback`](../-callback/index.md)`<`[`OffersResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-offers-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`fun getCoupons(): Observable<`[`OffersResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-offers-response/index.md)`>`<br>This method returns a list of offers that can be applied to an order |
| [getRewards](get-rewards.md) | `fun getRewards(callback: `[`Callback`](../-callback/index.md)`<`[`RewardsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-rewards-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`fun getRewards(): Observable<`[`RewardsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-rewards-response/index.md)`>`<br>This endpoint returns the list of rewards that are configured in the system. Rewards might be in one of the following states for a user |
