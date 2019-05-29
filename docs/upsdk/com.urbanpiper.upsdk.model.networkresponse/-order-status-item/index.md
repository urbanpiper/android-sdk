[upsdk](../../index.md) / [com.urbanpiper.upsdk.model.networkresponse](../index.md) / [OrderStatusItem](./index.md)

# OrderStatusItem

`data class OrderStatusItem`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `OrderStatusItem(id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, imgUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, landscapeImgUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, quantity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, price: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0.toFloat(), options: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OrderStatusItemOption`](../-order-status-item-option/index.md)`>, optionsToRemove: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OrderStatusItemOption`](../-order-status-item-option/index.md)`>, total: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0.toFloat(), taxes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`BillComponentValue`](../-bill-component-value/index.md)`>, charges: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`BillComponentValue`](../-bill-component-value/index.md)`>)` |

### Properties

| Name | Summary |
|---|---|
| [charges](charges.md) | `var charges: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`BillComponentValue`](../-bill-component-value/index.md)`>` |
| [id](id.md) | `var id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [imgUrl](img-url.md) | `var imgUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [landscapeImgUrl](landscape-img-url.md) | `var landscapeImgUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [options](options.md) | `var options: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OrderStatusItemOption`](../-order-status-item-option/index.md)`>` |
| [optionsToRemove](options-to-remove.md) | `var optionsToRemove: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`OrderStatusItemOption`](../-order-status-item-option/index.md)`>` |
| [price](price.md) | `var price: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [quantity](quantity.md) | `var quantity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [taxes](taxes.md) | `var taxes: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`BillComponentValue`](../-bill-component-value/index.md)`>` |
| [title](title.md) | `var title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [total](total.md) | `var total: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |

### Functions

| Name | Summary |
|---|---|
| [toJson](to-json.md) | `fun toJson(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
