package com.example.datapersistencewithrecyclerview.display

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.datapersistencewithrecyclerview.R
import com.example.datapersistencewithrecyclerview.database.CryptoDatabase
import com.example.datapersistencewithrecyclerview.databinding.FragmentDisplayBinding

class DisplayFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDisplayBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_display, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = CryptoDatabase.getInstance(application).cryptoDatabaseDao

        val viewModelFactory = DisplayViewModelFactory(dataSource)

        val displayViewModel =
            ViewModelProvider(this, viewModelFactory)[DisplayViewModel::class.java]

        binding.displayViewModel = displayViewModel

        val adapter = CryptoDetailsAdapter()
        binding.cryptoAddressList.adapter = adapter

        displayViewModel.details.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.lifecycleOwner = this

        return binding.root
    }
}