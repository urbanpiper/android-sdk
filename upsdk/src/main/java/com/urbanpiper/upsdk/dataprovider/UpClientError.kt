package com.urbanpiper.upsdk.dataprovider

import retrofit2.HttpException
import java.io.IOException

class UpClientError(var retrofitErrorThrowable: Throwable?) {
    /**
     * Represents any errors returning from the backend
     */
    val ERROR_TYPE_API = -2

    /**
     * Represents any network related errors
     */
    val ERROR_TYPE_NETWORK = -1

    /**
     * Represent any unknown errors
     */
    val ERROR_TYPE_UNKNOWN = 0

    private var type: Int

    private var httpErrorResponseCode: Int = -1

    init {
        if (retrofitErrorThrowable != null) {


            if (retrofitErrorThrowable is IOException) {
                type = ERROR_TYPE_NETWORK
            } else if (retrofitErrorThrowable is HttpException) {
                type = ERROR_TYPE_API
                httpErrorResponseCode = (retrofitErrorThrowable as HttpException).code()
            } else {
                type = ERROR_TYPE_UNKNOWN
            }


        } else {
            type = ERROR_TYPE_UNKNOWN
        }

    }

    /**
     * Returns the different types of errors
     *
     * -2 = ERROR_TYPE_API
     * -1 = ERROR_TYPE_NETWORK
     * 0 = ERROR_TYPE_UNKNOWN
     *
     */
    fun getType(): Int {
        return type
    }

    fun getThrowable(): Throwable? {
        return retrofitErrorThrowable
    }

    /**
     * This returns a -1 if the error is because of an IOException, only http errors are returned
     *
     */
    fun getResponseCode(): Int{
        return httpErrorResponseCode
    }

}