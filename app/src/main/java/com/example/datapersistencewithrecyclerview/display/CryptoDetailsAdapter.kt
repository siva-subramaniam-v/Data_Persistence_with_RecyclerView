package com.example.datapersistencewithrecyclerview.display

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.datapersistencewithrecyclerview.database.CryptoDetail
import com.example.datapersistencewithrecyclerview.databinding.ListItemDisplayBinding
import com.example.datapersistencewithrecyclerview.getDisplayString

class CryptoDetailsAdapter :
    ListAdapter<CryptoDetail, CryptoDetailsAdapter.ViewHolder>(CryptoDetailDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: ListItemDisplayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: CryptoDetail
        ) {
            val displayString = getDisplayString(item)
            binding.detailsText.text = displayString
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemDisplayBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class CryptoDetailDiffCallback : DiffUtil.ItemCallback<CryptoDetail>() {
    override fun areItemsTheSame(oldItem: CryptoDetail, newItem: CryptoDetail): Boolean {
        return oldItem.addressId == newItem.addressId
    }

    override fun areContentsTheSame(oldItem: CryptoDetail, newItem: CryptoDetail): Boolean {
        return oldItem == newItem
    }
}