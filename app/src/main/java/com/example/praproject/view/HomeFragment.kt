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
import com.denzcoskun.imageslider.models.SlideModel
import com.example.praproject.R
import android.os.Handler
import com.example.praproject.adapter.NewsUpdateAdapter
import com.example.praproject.adapter.ProductAdapter
import com.example.praproject.databinding.FragmentHomeBinding
import com.example.praproject.viewmodel.NewsUpdateViewModel
import com.example.praproject.viewmodel.ProductViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val imgSLiders = arrayListOf<SlideModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        imgSLiders.add(SlideModel("https://s3images.coroflot.com/user_files/individual_files/large_342665_pEpSJJXkEZDGA_3UtooVFOO88.jpg"))
        imgSLiders.add(SlideModel("https://www.concept-phones.com/wp-content/uploads/2020/05/iPhone-Slide-Pro-concept-design-1-680x450.jpg"))
        imgSLiders.add(SlideModel("https://dimsemenov.com/plugins/royal-slider/img/laptop.png"))
        imgSLiders.add(SlideModel("https://i0.wp.com/www.smartprix.com/bytes/wp-content/uploads/2022/05/iPhone14-1-photoutils.com_.jpeg"))

        val slidersLayout = binding.imageSliders
        slidersLayout.setImageList(imgSLiders)

        showDataNewsUpdate()
        showDataProduct()
    }

    fun showDataNewsUpdate() {
        val viewModelNews = ViewModelProvider(this).get(NewsUpdateViewModel::class.java)
        viewModelNews.getUpdate()
        viewModelNews.liveDataNewsUpdate.observe(this, Observer {
            if (it != null) {
                binding.rvNewsUpdate.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.rvNewsUpdate.adapter = NewsUpdateAdapter(it)
            }
        })
    }

    fun showDataProduct() {
        val viewModelProduct = ViewModelProvider(this).get(ProductViewModel::class.java)
        viewModelProduct.getProduct()
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