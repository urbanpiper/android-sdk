package com.urbanpiper.upsdk.dataprovider

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class InternalCallbackObserver<T>(val callback: Callback<T>) : Observer<T> {

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
        callback.success(t)
    }

    override fun onError(e: Throwable) {
        callback.failure(UpClientError(e))
    }

    override fun onComplete() {
    }


}
