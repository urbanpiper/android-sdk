[upsdk](../../index.md) / [com.urbanpiper.upsdk.model.networkresponse](../index.md) / [OrderDetail](./index.md)

# OrderDetail

`data class OrderDetail`

### Types

| Name | Summary |
|---|---|
| [Payment](-payment/index.md) | `data class Payment` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `OrderDetail(summary: `[`OrderStatusV2`](../-order-status-v2/index.md)`, items: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OrderStatusItem`](../-order-status-item/index.md)`> = ArrayList(), nextStates: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, nextState: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, payment: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Payment`](-payment/index.md)`>, store: `[`Store`](../-store/index.md)`)` |

### Properties

| Name | Summary |
|---|---|
| [items](items.md) | `var items: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OrderStatusItem`](../-order-status-item/index.md)`>` |
| [nextState](next-state.md) | `var nextState: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [nextStates](next-states.md) | `var nextStates: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [payment](payment.md) | `var payment: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Payment`](-payment/index.md)`>` |
| [store](store.md) | `var store: `[`Store`](../-store/index.md) |
| [summary](summary.md) | `var summary: `[`OrderStatusV2`](../-order-status-v2/index.md) |

### Functions

| Name | Summary |
|---|---|
| [toJson](to-json.md) | `fun toJson(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
