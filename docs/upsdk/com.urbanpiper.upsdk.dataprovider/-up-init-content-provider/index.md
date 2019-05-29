[upsdk](../../index.md) / [com.urbanpiper.upsdk.dataprovider](../index.md) / [UpInitContentProvider](./index.md)

# UpInitContentProvider

`class UpInitContentProvider : `[`ContentProvider`](https://developer.android.com/reference/android/content/ContentProvider.html)

This is an internal class used to init parts of the SDK

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `UpInitContentProvider()`<br>This is an internal class used to init parts of the SDK |

### Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | `fun delete(uri: `[`Uri`](https://developer.android.com/reference/android/net/Uri.html)`, selection: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, selectionArgs: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getType](get-type.md) | `fun getType(uri: `[`Uri`](https://developer.android.com/reference/android/net/Uri.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [insert](insert.md) | `fun insert(uri: `[`Uri`](https://developer.android.com/reference/android/net/Uri.html)`, values: `[`ContentValues`](https://developer.android.com/reference/android/content/ContentValues.html)`?): `[`Uri`](https://developer.android.com/reference/android/net/Uri.html)`?` |
| [onCreate](on-create.md) | `fun onCreate(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [query](query.md) | `fun query(uri: `[`Uri`](https://developer.android.com/reference/android/net/Uri.html)`, projection: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?, selection: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, selectionArgs: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?, sortOrder: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Cursor`](https://developer.android.com/reference/android/database/Cursor.html)`?` |
| [update](update.md) | `fun update(uri: `[`Uri`](https://developer.android.com/reference/android/net/Uri.html)`, values: `[`ContentValues`](https://developer.android.com/reference/android/content/ContentValues.html)`?, selection: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, selectionArgs: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>?): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
