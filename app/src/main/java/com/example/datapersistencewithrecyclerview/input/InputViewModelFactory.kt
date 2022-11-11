package com.example.datapersistencewithrecyclerview.input

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.datapersistencewithrecyclerview.database.CryptoDatabaseDao

class InputViewModelFactory(val dataSource: CryptoDatabaseDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InputViewModel::class.java)) {
            return InputViewModel(dataSource) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }
}