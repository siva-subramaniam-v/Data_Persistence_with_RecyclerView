package com.example.datapersistencewithrecyclerview

import android.widget.EditText
import com.example.datapersistencewithrecyclerview.database.CryptoDetail

fun areNotNull(vararg details: EditText): Boolean {
    return details.all {
        !it.text.isNullOrBlank()
    }
}

fun getDisplayString(detail: CryptoDetail): String {
    val displayString = StringBuilder("")

    displayString.append("Label: ${detail.label}\n")
    displayString.append("Address: ${detail.address}\n")
    displayString.append("Coin: ${detail.coinName}\n")
    displayString.append("Source: ${detail.addressSource}\n")

    return displayString.toString()
}