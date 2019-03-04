package com.urbanpiper.upsdk.dataprovider

import io.reactivex.disposables.CompositeDisposable

class CancellableTaskDisposableWrapper(private val compositeDisposable: CompositeDisposable): CancellableTask {

    override fun cancel() {
        compositeDisposable.dispose()
    }
}