package com.urbanpiper.upsdk.dataprovider

/**
 * Interface is used to help with cancelling a network request from retrofit
 */
interface CancellableTask {

    fun cancel()
}