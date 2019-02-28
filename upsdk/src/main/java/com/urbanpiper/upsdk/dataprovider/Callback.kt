package com.urbanpiper.upsdk.dataprovider

interface Callback<T> {

    fun success(response: T)

    fun failure(upClientError: UpClientError)

}