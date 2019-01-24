package com.urbanpiper.upsdk.dataprovider

interface UPClient: GeneralService, StoreService {

    fun getBizId(): String

    fun getApiUserName(): String

    fun getAPIKey(): String

    fun getBizLanguage(): String

}