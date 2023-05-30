package com.example.praproject.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.praproject.R
import com.example.praproject.data.endpoint.DataProductsItem
import com.example.praproject.databinding.ItemProductBinding
import com.example.praproject.dataclass.Detail

class ProductAdapter(private val listProducts: List<DataProductsItem>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(productItem: DataProductsItem) {
            binding.etJudul.text = productItem.name
            binding.etHarga.text = productItem.price.toString()
            Glide.with(binding.root)
                .load(productItem.productImage).into(binding.imgView)

            binding.detailList.setOnClickListener {
                val id = productItem.idProduct
                val imagepath = productItem.productImage
                val title = productItem.name
                val price = productItem.price.toString()
                val overview = productItem.description
                val date = productItem.createdAt

                val detail = Detail(id, imagepath, title, price, overview, date)

                val data = Bundle()
                data.putParcelable("product", detail)
                Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_detailFragment, data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productItem = listProducts[position]
        holder.bind(productItem)
    }

    override fun getItemCount(): Int {
        return listProducts.size
    }
}