[upsdk](../../index.md) / [com.urbanpiper.upsdk.model.networkresponse](../index.md) / [Biz](./index.md)

# Biz

`data class Biz`

This class represents the configured information for the business

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Biz(contactPhone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "", deliveryRadius: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0.toFloat(), timezone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, currency: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)` = "INR", pickupEnabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, paymentOptions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = arrayOf("prepaid", "cash"), walletReloadOpts: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>? = null, minOrderTotal: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`? = -1.0f, preProcess: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, deliveryMinOffsetTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 0, pickupMinOffsetTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = (3600 * 1000).toLong(), timeSlots: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TimeSlot`](../-time-slot/index.md)`>? = null, msgNoStoresNearby: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, msgNearestStoreClosed: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, msgNearestStoreClosedTemporary: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, feedbackConfigs: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FeedbackConfig`](../-feedback-config/index.md)`>? = null, usePointOfDelivery: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = false, referralUILbl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, referralShareLbl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, paymentGatewayProvider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, supportedLanguages: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`> = arrayOf("en"))`<br>This class represents the configured information for the business |

### Properties

| Name | Summary |
|---|---|
| [contactPhone](contact-phone.md) | `var contactPhone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<ul><li>Phone number of the business</li></ul> |
| [currency](currency.md) | `var currency: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<ul><li>currency of the business</li></ul> |
| [deliveryMinOffsetTime](delivery-min-offset-time.md) | `var deliveryMinOffsetTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<ul><li>minimum time for the order to be delivered</li></ul> |
| [deliveryRadius](delivery-radius.md) | `var deliveryRadius: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<ul><li>Delivery radius of the business</li></ul> |
| [feedbackConfigs](feedback-configs.md) | `var feedbackConfigs: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`FeedbackConfig`](../-feedback-config/index.md)`>?`<ul><li>The feedback options to be shown to the user, other than stars</li></ul> |
| [minOrderTotal](min-order-total.md) | `var minOrderTotal: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`?`<ul><li>minimum order total</li></ul> |
| [msgNearestStoreClosed](msg-nearest-store-closed.md) | `var msgNearestStoreClosed: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<ul><li>message to be shown when nearest store is closed</li></ul> |
| [msgNearestStoreClosedTemporary](msg-nearest-store-closed-temporary.md) | `var msgNearestStoreClosedTemporary: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<ul><li>message to be shown when nearest store is closed temp</li></ul> |
| [msgNoStoresNearby](msg-no-stores-nearby.md) | `var msgNoStoresNearby: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<ul><li>Message to be shown when no stores are nearby</li></ul> |
| [paymentGatewayProvider](payment-gateway-provider.md) | `var paymentGatewayProvider: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<ul><li>the payment gateway provider</li></ul> |
| [paymentOptions](payment-options.md) | `var paymentOptions: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`<ul><li>payment options of available</li></ul> |
| [pickupEnabled](pickup-enabled.md) | `var pickupEnabled: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<ul><li>boolean to show if pickup is enabled for the business</li></ul> |
| [pickupMinOffsetTime](pickup-min-offset-time.md) | `var pickupMinOffsetTime: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<ul><li>minimum time before the order can be picked up</li></ul> |
| [preProcess](pre-process.md) | `var preProcess: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<ul><li>pre process</li></ul> |
| [referralShareLbl](referral-share-lbl.md) | `var referralShareLbl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<ul><li>The text to be shown for the referral label</li></ul> |
| [referralUILbl](referral-u-i-lbl.md) | `var referralUILbl: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<ul><li>The text to be shown for referral label</li></ul> |
| [supportedLanguages](supported-languages.md) | `var supportedLanguages: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<ul><li>the languages supported by the business</li></ul> |
| [timeSlots](time-slots.md) | `var timeSlots: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`TimeSlot`](../-time-slot/index.md)`>?`<ul><li>Time slots for delivery</li></ul> |
| [timezone](timezone.md) | `var timezone: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`<ul><li>shows the time zone of the business</li></ul> |
| [usePointOfDelivery](use-point-of-delivery.md) | `var usePointOfDelivery: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<ul><li>Flag to use point of delivery mode</li></ul> |
| [walletReloadOpts](wallet-reload-opts.md) | `var walletReloadOpts: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?`<ul><li>wallet reload options for the business</li></ul> |

### Functions

| Name | Summary |
|---|---|
| [toJson](to-json.md) | `fun toJson(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
