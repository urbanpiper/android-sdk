package com.urbanpiper.upsdk.commons

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.pm.ProviderInfo
import android.database.Cursor
import android.net.Uri

/**
 * No operation. This class is used to get context for use with the library
 *
 */
class UPClientContextProvider : ContentProvider() {
    private var context1: Context? = null

    override fun onCreate(): Boolean {

        context1 = context

        return false
    }

    public fun getAppContext(): Context?{
        return context1
    }


    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }


    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
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
        return ""
    }


    /**
     * This method throws null pointer exception when the applicationId is not written in the application
     *
     * @param context
     * @param info
     */
    override fun attachInfo(context: Context?, info: ProviderInfo?) {

        if (info == null) {
            throw NullPointerException("YourLibraryInitProvider ProviderInfo cannot be null.");
        }

        if ("<your-library-applicationid>.yourlibraryinitprovider".equals(info.authority)) {
            throw IllegalStateException("Incorrect provider authority in manifest. Most likely due to a "
                    + "missing applicationId variable in application\'s build.gradle.");
        }
        super.attachInfo(context, info)

    }
}