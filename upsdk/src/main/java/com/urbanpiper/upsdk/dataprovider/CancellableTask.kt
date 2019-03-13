package com.urbanpiper.upsdk.dataprovider

/**
 * Interface is used to help with cancelling a network request made with retrofit
 */
interface CancellableTask {

    fun cancel()
}