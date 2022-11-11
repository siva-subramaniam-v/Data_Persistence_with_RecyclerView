package com.example.datapersistencewithrecyclerview.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CryptoDetail::class], version = 1, exportSchema = false)
abstract class CryptoDatabase : RoomDatabase() {
    abstract val cryptoDatabaseDao: CryptoDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: CryptoDatabase? = null

        fun getInstance(context: Context): CryptoDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CryptoDatabase::class.java,
                        "crypto_address_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}