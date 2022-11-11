package com.example.datapersistencewithrecyclerview.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto_address_table")
data class CryptoDetail(
    @PrimaryKey(autoGenerate = true)
    var addressId: Long = 0L,

    var label: String = "",

    var address: String = "",

    @ColumnInfo(name = "coin_name")
    var coinName: String = "",

    @ColumnInfo(name = "address_source")
    var addressSource: String = ""
)