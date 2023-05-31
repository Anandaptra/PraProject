package com.example.praproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.praproject.R
import com.example.praproject.databinding.FragmentDetailBinding
import com.example.praproject.dataclass.Cart
import com.example.praproject.dataclass.Detail
import com.example.praproject.dataclass.Favourite
import com.example.praproject.viewmodel.DetailViewModel

class DetailFragment : Fragment() {
    val detailVM: DetailViewModel by viewModels()
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arguments?.getParcelable<Detail>("product") as Detail

        val imagepath = list.imagePath
        val title = list.title
        val price = list.price
        val overview = list.overview
        val date = list.Date

        binding.etTitle.text = title
        binding.etPrice.text = price
        binding.etDesc.text = overview
        binding.etDate.text = date
        Glide.with(binding.root).load(imagepath).into(binding.imgProduct)

        binding.addFav.setOnClickListener{
            postFav(Favourite(title, imagepath, price))
        }

        binding.addCart.setOnClickListener {
            postCart(Cart(title, imagepath, price))
        }
    }

    fun postFav(fav: Favourite){
        detailVM.postFav(fav)
        detailVM.addFav.observe(this){
            if(it != null){
                Toast.makeText(requireContext(), "Berhasil menambahkan ke favourite", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Gagal menambahkan ke favourite", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun postCart(cart: Cart){
        detailVM.postCart(cart)
        detailVM.addCart.observe(this){
            if(it != null){
                Toast.makeText(requireContext(), "Berhasil menambahkan ke cart", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Gagal menambahkan ke cart", Toast.LENGTH_SHORT).show()
            }
        }
    }
}