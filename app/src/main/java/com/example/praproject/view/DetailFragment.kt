package com.example.praproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.praproject.R
import com.example.praproject.databinding.FragmentDetailBinding
import com.example.praproject.dataclass.Detail

class DetailFragment : Fragment() {

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

        // pengambilan data
        val list = arguments?.getParcelable<Detail>("product") as Detail

        val id = list.id
        val imagepath = list.imagePath
        val title = list.title
        val price = list.price
        val overview = list.overview
        val date = list.Date

        binding.tvTitle.text = title
        binding.tvPrice.text = price
        binding.tvDeesc.text = overview
        binding.tvDate.text = date
        Glide.with(binding.root).load(imagepath).into(binding.imagepath)

    }

}