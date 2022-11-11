package com.example.datapersistencewithrecyclerview.input

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.datapersistencewithrecyclerview.R
import com.example.datapersistencewithrecyclerview.areNotNull
import com.example.datapersistencewithrecyclerview.database.CryptoDatabase
import com.example.datapersistencewithrecyclerview.databinding.FragmentInputBinding

class InputFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInputBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_input, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = CryptoDatabase.getInstance(application).cryptoDatabaseDao

        val viewModelFactory = InputViewModelFactory(dataSource)

        val inputViewModel = ViewModelProvider(this, viewModelFactory)[InputViewModel::class.java]

        binding.addButton.setOnClickListener {
            binding.apply {
                if (areNotNull(labelEditText, addressEditText, coinEditText, sourceEditText)) {
                    inputViewModel.onAdd(
                        labelEditText.text.toString(),
                        addressEditText.text.toString(),
                        coinEditText.text.toString(),
                        sourceEditText.text.toString()
                    )

                    labelEditText.setText("")
                    addressEditText.setText("")
                    coinEditText.setText("")
                    sourceEditText.setText("")

                    Toast.makeText(
                        binding.root.context,
                        "Address added successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        binding.root.context, "Please fill all the fields", Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        return binding.root
    }
}