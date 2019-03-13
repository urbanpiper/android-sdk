package com.urbanpiper.upsdk.dataprovider

/**
 * This callback returns the response from a network call
 *
 * success - Returns the success response from the network call, if it succeeded
 * failure - Returns an error from the network call, if it failed
 *
 * @param T - Type of network response
 */
interface Callback<T> {

    fun success(response: T)

    fun failure(upClientError: UpClientError)

}