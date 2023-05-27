package com.example.praproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.praproject.data.endpoint.DataNewsUpdateItem
import com.example.praproject.databinding.ItemNewsupdateBinding

class NewsUpdateAdapter(private val listNews: List<DataNewsUpdateItem>) : RecyclerView.Adapter<NewsUpdateAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemNewsupdateBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(newsItem: DataNewsUpdateItem) {
            binding.etJudul.text = newsItem.title
            binding.etTanggal.text = newsItem.createdAt
            Glide.with(binding.root)
                .load(newsItem.newsImage).into(binding.imgView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsupdateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsItem = listNews[position]
        holder.bind(newsItem)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }
}