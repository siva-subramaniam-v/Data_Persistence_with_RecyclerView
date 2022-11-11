package com.example.datapersistencewithrecyclerview.input

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datapersistencewithrecyclerview.database.CryptoDatabaseDao
import com.example.datapersistencewithrecyclerview.database.CryptoDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InputViewModel(
    val database: CryptoDatabaseDao
) : ViewModel() {
    fun onAdd(label: String, address: String, coin: String, source: String) {
        viewModelScope.launch {
            val newDetail = CryptoDetail(
                label = label,
                address = address,
                coinName = coin,
                addressSource = source
            ).also {
                insert(it)
            }
        }
    }

    private suspend fun insert(detail: CryptoDetail) {
        withContext(Dispatchers.IO) {
            database.insert(detail)
        }
    }
}