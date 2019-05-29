[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [PromotionsRetrofitService](./index.md)

# PromotionsRetrofitService

`interface PromotionsRetrofitService`

### Functions

| Name | Summary |
|---|---|
| [getBanners](get-banners.md) | `abstract fun getBanners(authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, type: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "app_banner"): Observable<`[`BannerResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-banner-response/index.md)`>` |
| [getOffers](get-offers.md) | `abstract fun getOffers(authToken: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`OffersResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-offers-response/index.md)`>` |
| [getRewards](get-rewards.md) | `abstract fun getRewards(apiAuth: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, bizId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Observable<`[`RewardsResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-rewards-response/index.md)`>` |
