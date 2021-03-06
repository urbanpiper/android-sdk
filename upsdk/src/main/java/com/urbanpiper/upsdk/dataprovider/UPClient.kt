package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.User

interface UPClient : GeneralService, CatalogueService, UserService, PromotionsService, CartService {

    /**
     * Returns biz id
     *
     */
    fun getBizId(): String

    /**
     * Returns api username
     *
     */
    fun getApiUserName(): String

    /**
     * Returns api key
     *
     */
    fun getAPIKey(): String

    /**
     * Returns current language being passed to the SDK
     *
     */
    fun getBizLanguage(): String

    /**
     * This method is used to change the language of the response being passed to the SDK
     *
     * @param language
     */
    fun changeLanguage(language: String)

    /**
     * This method returns an instance of the Registration Builder
     */
    fun getRegistrationBuilder(): RegistrationBuilder

    /**
     * This method returns an instance of the Checkout Builder
     */
    fun getCheckOutBuilder(): CheckoutBuilder

    /**
     * This method returns an instance of the reset password builder
     */
    fun getResetPasswordBuilder(): ResetPasswordBuilder

    /**
     * This method returns an instance of the social reg builder
     */
    fun getSocialRegBuilder(): SocialRegBuilder

    /**
     * This method returns an instance of the item option builder
     */
    fun getItemOptionBuilder(): ItemOptionBuilder

    /**
     * This method returns an instance of the user object, it can be null if
     * user is not signed in
     */
    fun getUser(): User?

    /**
     * Returns an instance of the local cart
     */
    fun getCart(locationId: Int): Cart

    /**
     * Returns an instance of the biz data
     */
//    fun getBiz(): Biz
}