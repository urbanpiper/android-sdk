package com.urbanpiper.upsdk.dataprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import androidx.annotation.RestrictTo

/**
 * This is an internal class used to init parts of the SDK
 *
 */
@RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
class UpInitContentProvider : ContentProvider() {

    // Initialization can happen here
    override fun onCreate(): Boolean {
        // Init shared preferences manager
        SharedPrefManager.init(context)
        // Init the cart database
        Cart.init(context)
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return null
    }


    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }
}