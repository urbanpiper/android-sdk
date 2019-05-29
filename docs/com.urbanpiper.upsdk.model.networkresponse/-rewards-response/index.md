[upsdk](../../index.md) / [com.urbanpiper.upsdk.model.networkresponse](../index.md) / [RewardsResponse](./index.md)

# RewardsResponse

`data class RewardsResponse`

### Types

| Name | Summary |
|---|---|
| [PreviousClaims](-previous-claims/index.md) | `data class PreviousClaims` |
| [Reward](-reward/index.md) | `data class Reward` |
| [RewardRedemption](-reward-redemption/index.md) | `data class RewardRedemption` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `RewardsResponse(meta: `[`ResponseMeta`](../-response-meta/index.md)`, inStoreCouponRewards: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Reward`](-reward/index.md)`>, locked: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Reward`](-reward/index.md)`>, unlocked: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Reward`](-reward/index.md)`>, claimed: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Reward`](-reward/index.md)`>, redeemedButNotClaimed: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Reward`](-reward/index.md)`>, allRewards: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Reward`](-reward/index.md)`> = ArrayList())` |

### Properties

| Name | Summary |
|---|---|
| [allRewards](all-rewards.md) | `var allRewards: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Reward`](-reward/index.md)`>` |
| [claimed](claimed.md) | `var claimed: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Reward`](-reward/index.md)`>` |
| [inStoreCouponRewards](in-store-coupon-rewards.md) | `var inStoreCouponRewards: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Reward`](-reward/index.md)`>` |
| [locked](locked.md) | `var locked: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Reward`](-reward/index.md)`>` |
| [meta](meta.md) | `var meta: `[`ResponseMeta`](../-response-meta/index.md) |
| [redeemedButNotClaimed](redeemed-but-not-claimed.md) | `var redeemedButNotClaimed: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Reward`](-reward/index.md)`>` |
| [unlocked](unlocked.md) | `var unlocked: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Reward`](-reward/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [toJson](to-json.md) | `fun toJson(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
