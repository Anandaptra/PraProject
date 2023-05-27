package com.example.praproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.praproject.R
import com.example.praproject.adapter.NewsUpdateAdapter
import com.example.praproject.adapter.ProductAdapter
import com.example.praproject.databinding.FragmentHomeBinding
import com.example.praproject.viewmodel.NewsUpdateViewModel
import com.example.praproject.viewmodel.ProductViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onStart() {
        super.onStart()

        val viewModelNews = ViewModelProvider(this).get(NewsUpdateViewModel::class.java)
        viewModelNews.callApiNews()
        viewModelNews.liveDataNewsUpdate.observe(viewLifecycleOwner, Observer { newsupdateList ->
            if (newsupdateList != null) {
                val newsAdapter = NewsUpdateAdapter(newsupdateList)
                binding.rvNewsUpdate.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                binding.rvNewsUpdate.adapter = newsAdapter
            }
        })

        val viewModelProduct = ViewModelProvider(this).get(ProductViewModel::class.java)
        viewModelProduct.callApiNews()
        viewModelProduct.liveProduct.observe(viewLifecycleOwner, Observer { productList ->
            if (productList != null) {
                val productsAdapter = ProductAdapter(productList)
                binding.rvProducts.layoutManager =
                    GridLayoutManager(requireContext(), 2)
                binding.rvProducts.adapter = productsAdapter
            }
        })
    }
}