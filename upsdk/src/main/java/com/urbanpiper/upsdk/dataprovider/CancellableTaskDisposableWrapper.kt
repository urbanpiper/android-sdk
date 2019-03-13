package com.urbanpiper.upsdk.dataprovider

import io.reactivex.disposables.CompositeDisposable

/**
 * Helper method to cancel network requests
 *
 * @property compositeDisposable - Disposable that has to be disposed
 */
class CancellableTaskDisposableWrapper(private val compositeDisposable: CompositeDisposable): CancellableTask {

    override fun cancel() {
        compositeDisposable.dispose()
    }
}