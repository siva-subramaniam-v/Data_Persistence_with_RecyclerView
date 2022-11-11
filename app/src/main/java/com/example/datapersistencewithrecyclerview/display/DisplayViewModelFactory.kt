package com.example.datapersistencewithrecyclerview.display

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.datapersistencewithrecyclerview.database.CryptoDatabaseDao

class DisplayViewModelFactory(private val dataSource: CryptoDatabaseDao) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DisplayViewModel::class.java)) {
            return DisplayViewModel(dataSource) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class")
    }
}