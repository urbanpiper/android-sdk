package com.urbanpiper.upsdk.dataprovider

import retrofit2.Call

/**
 * This is a wrapper class, it wraps retrofit's Call<T> as a cancellable task
 */
class CancellableTaskWrapper<T>(private val call: Call<T>) : CancellableTask {

    override fun cancel() {
        call.cancel()
    }
}