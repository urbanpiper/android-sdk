package com.urbanpiper.upsdk.dataprovider

import com.urbanpiper.upsdk.model.networkresponse.Biz

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

    fun getUser(): User

    fun getBizInfo(): Biz
}