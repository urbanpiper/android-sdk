package com.urbanpiper.upsdk.dataprovider

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.urbanpiper.upsdk.model.entity.*
import com.urbanpiper.upsdk.model.networkresponse.CartItem

@Database(entities = [CartItem::class], version = 1)
@TypeConverters(
    OrderItemOptionTypeConverter::class,
    OrderItemOptionGroupTypeConverter::class,
    OrderCategoryTypeConverter::class,
    FulfillmentModeTypeConverter::class
)
public abstract class CartRoomDatabase : RoomDatabase() {

    abstract fun cartDao(): CartDao

    // This makes the database a singleton to prevent having multiple
    // instances of the database opened at the same time
    companion object {

        @Volatile
        private var INSTANCE: CartRoomDatabase? = null

        fun getDatabase(context: Context): CartRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CartRoomDatabase::class.java,
                    "Word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}