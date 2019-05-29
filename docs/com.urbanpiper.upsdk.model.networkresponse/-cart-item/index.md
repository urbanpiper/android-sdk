[upsdk](../../index.md) / [com.urbanpiper.upsdk.model.networkresponse](../index.md) / [CartItem](./index.md)

# CartItem

`data class CartItem`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CartItem(databaseId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = 0, id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, imgUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, imgLandscapeUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, desc: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, price: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`? = 0.toFloat(), current_stock: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = -1, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, sortOrder: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = 0, serviceTaxRate: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`? = 0.toFloat(), vatRate: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`? = 0.toFloat(), optionGroups: `[`ArrayList`](https://developer.android.com/reference/java/util/ArrayList.html)`<`[`OrderItemOptionGroup`](../-order-item-option-group/index.md)`?>? = ArrayList(), optionsSelectedForOrdering: `[`ArrayList`](https://developer.android.com/reference/java/util/ArrayList.html)`<`[`OrderItemOption`](../-order-item-option/index.md)`?>? = ArrayList(), optionsSelectedForRemoval: `[`ArrayList`](https://developer.android.com/reference/java/util/ArrayList.html)`<`[`OrderItemOption`](../-order-item-option/index.md)`?>? = ArrayList(), quantity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = 0, discount: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`? = 0.toFloat(), foodType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = 0, itemCategory: `[`OrderCategory`](../-order-category/index.md)`?, category: `[`OrderCategory`](../-order-category/index.md)`?, subCategory: `[`OrderCategory`](../-order-category/index.md)`?, fulfillmentModes: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?, priceDesc: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, preOrderStartTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?, preOrderEndTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?, likes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`? = 0, userLiked: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`? = false)` |

### Properties

| Name | Summary |
|---|---|
| [category](category.md) | `var category: `[`OrderCategory`](../-order-category/index.md)`?` |
| [current_stock](current_stock.md) | `var current_stock: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |
| [databaseId](database-id.md) | `var databaseId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |
| [desc](desc.md) | `var desc: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [discount](discount.md) | `var discount: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`?` |
| [foodType](food-type.md) | `var foodType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |
| [fulfillmentModes](fulfillment-modes.md) | `var fulfillmentModes: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?` |
| [id](id.md) | `var id: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [imgLandscapeUrl](img-landscape-url.md) | `var imgLandscapeUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [imgUrl](img-url.md) | `var imgUrl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [itemCategory](item-category.md) | `var itemCategory: `[`OrderCategory`](../-order-category/index.md)`?` |
| [likes](likes.md) | `var likes: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |
| [name](name.md) | `var name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [optionGroups](option-groups.md) | `var optionGroups: `[`ArrayList`](https://developer.android.com/reference/java/util/ArrayList.html)`<`[`OrderItemOptionGroup`](../-order-item-option-group/index.md)`?>?` |
| [optionsSelectedForOrdering](options-selected-for-ordering.md) | `var optionsSelectedForOrdering: `[`ArrayList`](https://developer.android.com/reference/java/util/ArrayList.html)`<`[`OrderItemOption`](../-order-item-option/index.md)`?>?` |
| [optionsSelectedForRemoval](options-selected-for-removal.md) | `var optionsSelectedForRemoval: `[`ArrayList`](https://developer.android.com/reference/java/util/ArrayList.html)`<`[`OrderItemOption`](../-order-item-option/index.md)`?>?` |
| [preOrderEndTime](pre-order-end-time.md) | `var preOrderEndTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?` |
| [preOrderStartTime](pre-order-start-time.md) | `var preOrderStartTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?` |
| [price](price.md) | `var price: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`?` |
| [priceDesc](price-desc.md) | `var priceDesc: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [quantity](quantity.md) | `var quantity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |
| [serviceTaxRate](service-tax-rate.md) | `var serviceTaxRate: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`?` |
| [sortOrder](sort-order.md) | `var sortOrder: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`?` |
| [subCategory](sub-category.md) | `var subCategory: `[`OrderCategory`](../-order-category/index.md)`?` |
| [userLiked](user-liked.md) | `var userLiked: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`?` |
| [vatRate](vat-rate.md) | `var vatRate: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`?` |

### Functions

| Name | Summary |
|---|---|
| [equals](equals.md) | `fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hasOptions](has-options.md) | `fun hasOptions(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hashCode](hash-code.md) | `fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [toJson](to-json.md) | `fun toJson(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
