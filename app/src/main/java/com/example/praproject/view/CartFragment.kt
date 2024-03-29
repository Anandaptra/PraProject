package com.example.praproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.praproject.R
import com.example.praproject.adapter.CartAdapter
import com.example.praproject.adapter.FavouriteAdapter
import com.example.praproject.databinding.FragmentCartBinding
import com.example.praproject.viewmodel.CartViewModel
import com.example.praproject.viewmodel.FavouriteViewModel

class CartFragment : Fragment() {
    lateinit var binding: FragmentCartBinding
    private val cartVm: CartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showCart()
    }

    fun showCart(){
        cartVm.getCart()
        cartVm.cart.observe(this){
            if(it != null){
                binding.apply {
                    rvCart.adapter = CartAdapter(it)
                    rvCart.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                }
            }
        }
    }
}