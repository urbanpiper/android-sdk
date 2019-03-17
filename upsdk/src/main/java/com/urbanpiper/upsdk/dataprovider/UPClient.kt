package com.urbanpiper.upsdk.dataprovider

interface UPClient : GeneralService, CatalogueService, UserService, PromotionsService, CartService {

    fun getBizId(): String

    fun getApiUserName(): String

    fun getAPIKey(): String

    fun getBizLanguage(): String

    fun changeLanguage(language: String)

    fun getRegistrationBuilder(): RegistrationBuilder

    fun getCheckOutBuilder(): CheckoutBuilder

    fun getResetPasswordBuilder(): ResetPasswordBuilder

    fun getSocialRegBuilder(): SocialRegBuilder

    fun getItemOptionBuilder(): ItemOptionBuilder
}