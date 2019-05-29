[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UPClientDefault](index.md) / [getBanners](./get-banners.md)

# getBanners

`fun getBanners(callback: `[`Callback`](../-callback/index.md)`<`[`BannerResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-banner-response/index.md)`>): `[`CancellableTask`](../-cancellable-task/index.md)

Overrides [PromotionsService.getBanners](../-promotions-service/get-banners.md)

The Gallery method returns the list of images that have been uploaded through the configuration portal.

These images might be used for different visual purposes, such as:

* showing banners in a carousel in the website or app.
* showing a promotional popup.

### Parameters

`callback` -
* Callback to return the result

**Return**
CancellableTask - the request can be cancelled by calling .cancel() on the CancellableTask

`fun getBanners(): Observable<`[`BannerResponse`](../../com.urbanpiper.upsdk.model.networkresponse/-banner-response/index.md)`>`

Overrides [PromotionsService.getBanners](../-promotions-service/get-banners.md)

The Gallery method returns the list of images that have been uploaded through the configuration portal.

These images might be used for different visual purposes, such as:

* showing banners in a carousel in the website or app.
* showing a promotional popup.

**Return**
Observable - the result of the network request is returned as an Observable

