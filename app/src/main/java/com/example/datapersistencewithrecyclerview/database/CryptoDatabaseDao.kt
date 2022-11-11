package com.example.datapersistencewithrecyclerview.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CryptoDatabaseDao {
    @Insert
    fun insert(detail: CryptoDetail)

    @Query("SELECT * FROM crypto_address_table")
    fun getAll(): LiveData<List<CryptoDetail>>

    @Query("SELECT * FROM crypto_address_table WHERE address_source = :source")
    fun filterBySource(source: String): List<CryptoDetail> // make livedata

    @Query("SELECT * FROM crypto_address_table WHERE coin_name = :coin")
    fun filterByCoin(coin: String): List<CryptoDetail> // make livedata

    @Query("DELETE FROM crypto_address_table")
    fun clear()
}