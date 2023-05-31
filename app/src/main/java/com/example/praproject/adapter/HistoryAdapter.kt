package com.example.praproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.praproject.data.endpoint.DataCartItem
import com.example.praproject.data.endpoint.DataTranshistoryItem
import com.example.praproject.databinding.ItemNewsupdateBinding

class HistoryAdapter(private val listHistory: List<DataTranshistoryItem>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemNewsupdateBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(favItem: DataTranshistoryItem) {
            binding.etJudul.text = favItem.name
            binding.etTanggal.text = favItem.price.toString()
            Glide.with(binding.root).load(favItem.picture).into(binding.imgView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsupdateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val historyItem = listHistory[position]
        holder.bind(historyItem)
    }

    override fun getItemCount(): Int {
        return listHistory.size
    }
}