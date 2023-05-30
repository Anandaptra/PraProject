package com.example.praproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.praproject.data.endpoint.DataFavouriteItem
import com.example.praproject.data.endpoint.DataNewsUpdateItem
import com.example.praproject.databinding.ItemNewsupdateBinding

class FavouriteAdapter(private val listFavourite: List<DataFavouriteItem>) : RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemNewsupdateBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(favItem: DataFavouriteItem) {
            binding.etJudul.text = favItem.name
            binding.etTanggal.text = favItem.price.toString()
            Glide.with(binding.root).load(favItem.productImage).into(binding.imgView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsupdateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsItem = listFavourite[position]
        holder.bind(newsItem)
    }

    override fun getItemCount(): Int {
        return listFavourite.size
    }
}