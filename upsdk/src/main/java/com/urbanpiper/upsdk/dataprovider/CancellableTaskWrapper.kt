package com.urbanpiper.upsdk.dataprovider

import retrofit2.Call

class CancellableTaskWrapper<T>(private val call: Call<T>) : CancellableTask {

    override fun cancel() {
        call.cancel()
    }
}