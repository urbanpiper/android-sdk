package com.urbanpiper.upsdk.dataprovider

interface UPClient : GeneralService, StoreService, CatalogueService, UserService {

    fun getBizId(): String

    fun getApiUserName(): String

    fun getAPIKey(): String

    fun getBizLanguage(): String

    fun changeLanguage(language: String)

}