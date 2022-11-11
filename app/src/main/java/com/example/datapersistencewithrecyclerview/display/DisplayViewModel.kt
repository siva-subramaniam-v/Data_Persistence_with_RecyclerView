package com.example.datapersistencewithrecyclerview.display

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datapersistencewithrecyclerview.database.CryptoDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DisplayViewModel(
    val database: CryptoDatabaseDao
) : ViewModel() {
    val details = database.getAll()

    fun onClear() {
        viewModelScope.launch {
            clearDatabase()
        }
    }

    private suspend fun clearDatabase() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }
}