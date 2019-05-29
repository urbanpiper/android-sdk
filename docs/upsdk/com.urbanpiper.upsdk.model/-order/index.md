[upsdk](../../index.md) / [com.urbanpiper.upsdk.model](../index.md) / [Order](./index.md)

# Order

`data class Order`

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Order(id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, storeId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 0, deliveryCharge: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0f, packagingCharge: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0f, taxRate: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0f, subtotalAmt: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0f, totalAmt: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0f, payableAmt: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0f, deliveryTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0, deliveryType: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, paymentOption: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, coupon: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, trxId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, lat: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, lng: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)` = 0.0, totalItemTaxes: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0f, discountApplied: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0f, channel: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "app_android", discount: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0f, discountObj: `[`Discount`](../../com.urbanpiper.upsdk.model.networkresponse/-discount/index.md)`? = null, store: `[`Store`](../../com.urbanpiper.upsdk.model.networkresponse/-store/index.md)`, items: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`> = ArrayList(), cartItems: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`> = ArrayList(), address: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, applyWalletCredit: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`? = false, walletCreditsApplicable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, walletCreditApplied: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`? = 0.0f, totalTaxes: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`? = 0f, totalCharges: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`? = 0f, addressId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = -1, timeSlotStart: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, timeSlotEnd: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, state: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, instructions: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, created: `[`Date`](https://developer.android.com/reference/java/util/Date.html)`, paymentModes: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>)` |

### Properties

| Name | Summary |
|---|---|
| [DELIVERY_TYPE_DELIVERY](-d-e-l-i-v-e-r-y_-t-y-p-e_-d-e-l-i-v-e-r-y.md) | `val DELIVERY_TYPE_DELIVERY: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [DELIVERY_TYPE_PICKUP](-d-e-l-i-v-e-r-y_-t-y-p-e_-p-i-c-k-u-p.md) | `val DELIVERY_TYPE_PICKUP: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ORDER_STATE_AWAITING_PAYMENT](-o-r-d-e-r_-s-t-a-t-e_-a-w-a-i-t-i-n-g_-p-a-y-m-e-n-t.md) | `val ORDER_STATE_AWAITING_PAYMENT: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [PAYMENT_OPT_CASH](-p-a-y-m-e-n-t_-o-p-t_-c-a-s-h.md) | `val PAYMENT_OPT_CASH: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [PAYMENT_OPT_ONLINE_INSTAMOJO](-p-a-y-m-e-n-t_-o-p-t_-o-n-l-i-n-e_-i-n-s-t-a-m-o-j-o.md) | `val PAYMENT_OPT_ONLINE_INSTAMOJO: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [PAYMENT_OPT_ONLINE_RZP](-p-a-y-m-e-n-t_-o-p-t_-o-n-l-i-n-e_-r-z-p.md) | `val PAYMENT_OPT_ONLINE_RZP: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [PAYMENT_OPT_PAYPAL](-p-a-y-m-e-n-t_-o-p-t_-p-a-y-p-a-l.md) | `val PAYMENT_OPT_PAYPAL: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [PAYMENT_OPT_PAYTM](-p-a-y-m-e-n-t_-o-p-t_-p-a-y-t-m.md) | `val PAYMENT_OPT_PAYTM: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [PAYMENT_OPT_PG](-p-a-y-m-e-n-t_-o-p-t_-p-g.md) | `val PAYMENT_OPT_PG: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [PAYMENT_OPT_PREPAID](-p-a-y-m-e-n-t_-o-p-t_-p-r-e-p-a-i-d.md) | `val PAYMENT_OPT_PREPAID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [PAYMENT_OPT_SELECT](-p-a-y-m-e-n-t_-o-p-t_-s-e-l-e-c-t.md) | `val PAYMENT_OPT_SELECT: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [PAYMENT_OPT_SIMPL](-p-a-y-m-e-n-t_-o-p-t_-s-i-m-p-l.md) | `val PAYMENT_OPT_SIMPL: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [address](address.md) | `var address: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [addressId](address-id.md) | `var addressId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [applyWalletCredit](apply-wallet-credit.md) | `var applyWalletCredit: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`?` |
| [cartItems](cart-items.md) | `var cartItems: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`>` |
| [channel](channel.md) | `var channel: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [coupon](coupon.md) | `var coupon: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [created](created.md) | `var created: `[`Date`](https://developer.android.com/reference/java/util/Date.html) |
| [deliveryCharge](delivery-charge.md) | `var deliveryCharge: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [deliveryTime](delivery-time.md) | `var deliveryTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [deliveryType](delivery-type.md) | `var deliveryType: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [discount](discount.md) | `var discount: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [discountApplied](discount-applied.md) | `var discountApplied: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [discountObj](discount-obj.md) | `var discountObj: `[`Discount`](../../com.urbanpiper.upsdk.model.networkresponse/-discount/index.md)`?` |
| [id](id.md) | `var id: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [instructions](instructions.md) | `var instructions: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [items](items.md) | `var items: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`CartItem`](../../com.urbanpiper.upsdk.model.networkresponse/-cart-item/index.md)`>` |
| [lat](lat.md) | `var lat: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [lng](lng.md) | `var lng: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [packagingCharge](packaging-charge.md) | `var packagingCharge: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [payableAmt](payable-amt.md) | `var payableAmt: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [paymentModes](payment-modes.md) | `var paymentModes: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [paymentOption](payment-option.md) | `var paymentOption: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [phone](phone.md) | `var phone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [state](state.md) | `var state: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [store](store.md) | `var store: `[`Store`](../../com.urbanpiper.upsdk.model.networkresponse/-store/index.md) |
| [storeId](store-id.md) | `var storeId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [subtotalAmt](subtotal-amt.md) | `var subtotalAmt: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [taxRate](tax-rate.md) | `var taxRate: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [timeSlotEnd](time-slot-end.md) | `var timeSlotEnd: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [timeSlotStart](time-slot-start.md) | `var timeSlotStart: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [totalAmt](total-amt.md) | `var totalAmt: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [totalCharges](total-charges.md) | `var totalCharges: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`?` |
| [totalItemTaxes](total-item-taxes.md) | `var totalItemTaxes: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [totalTaxes](total-taxes.md) | `var totalTaxes: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`?` |
| [trxId](trx-id.md) | `var trxId: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [walletCreditApplied](wallet-credit-applied.md) | `var walletCreditApplied: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`?` |
| [walletCreditsApplicable](wallet-credits-applicable.md) | `var walletCreditsApplicable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Functions

| Name | Summary |
|---|---|
| [toJson](to-json.md) | `fun toJson(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
