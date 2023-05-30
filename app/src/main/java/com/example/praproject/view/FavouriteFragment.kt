package com.example.praproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.praproject.R
import com.example.praproject.adapter.FavouriteAdapter
import com.example.praproject.databinding.FragmentFavouriteBinding
import com.example.praproject.viewmodel.FavouriteViewModel

class FavouriteFragment : Fragment() {
    private lateinit var binding: FragmentFavouriteBinding
    private val favVM: FavouriteViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showFavouriteItem()
    }

    fun showFavouriteItem(){
        favVM.getFavouriteItem()
        favVM.favourite.observe(this){
            if(it != null){
                binding.apply {
                    rvFavourite.adapter = FavouriteAdapter(it)
                    rvFavourite.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                }
            }
        }
    }
}