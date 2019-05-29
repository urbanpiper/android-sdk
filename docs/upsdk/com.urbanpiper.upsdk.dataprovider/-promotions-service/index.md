[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [PromotionsService](./index.md)

# PromotionsService

`interface PromotionsService`

### Functions

| Name | Summary |
|---|---|
| [getBanners](get-banners.md) | `abstract fun getBanners(callback: `[`Callback`](../-callback/index.md)`<`[`BannerResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-banner-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`abstract fun getBanners(): Observable<`[`BannerResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-banner-response/index.md)`>`<br>The method returns the list of images that have been uploaded through the configuration portal. |
| [getCoupons](get-coupons.md) | `abstract fun getCoupons(callback: `[`Callback`](../-callback/index.md)`<`[`OffersResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-offers-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`abstract fun getCoupons(): Observable<`[`OffersResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-offers-response/index.md)`>`<br>This method returns a list of offers that can be applied to an order |
| [getRewards](get-rewards.md) | `abstract fun getRewards(callback: `[`Callback`](../-callback/index.md)`<`[`RewardsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-rewards-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)<br>`abstract fun getRewards(): Observable<`[`RewardsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-rewards-response/index.md)`>`<br>This endpoint returns the list of rewards that are configured in the system. Rewards might be in one of the following states for a user |

### Inheritors

| Name | Summary |
|---|---|
| [PromotionsServiceDefault](../-promotions-service-default/index.md) | `class PromotionsServiceDefault : `[`PromotionsService`](./index.md) |
| [UPClient](../-u-p-client/index.md) | `interface UPClient : `[`GeneralService`](../-general-service/index.md)`, `[`CatalogueService`](../-catalogue-service/index.md)`, `[`UserService`](../-user-service/index.md)`, `[`PromotionsService`](./index.md)`, `[`CartService`](../-cart-service/index.md) |
