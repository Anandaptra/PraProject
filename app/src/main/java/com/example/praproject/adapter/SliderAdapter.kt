package com.example.praproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.praproject.data.endpoint.DataSliderItem
import com.example.praproject.databinding.ItemSliderBinding

class SliderAdapter(private val items: List<DataSliderItem>) : RecyclerView.Adapter<SliderAdapter.ViewHolder>() {
    class ViewHolder (private val binding: ItemSliderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataSliderItem) {
            Glide.with(itemView).load(data.image).into(binding.ivSlider)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}