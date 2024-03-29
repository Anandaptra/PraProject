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
import com.example.praproject.adapter.HistoryAdapter
import com.example.praproject.databinding.FragmentHistoryBinding
import com.example.praproject.viewmodel.CartViewModel
import com.example.praproject.viewmodel.HistoryViewModel

class HistoryFragment : Fragment() {
    lateinit var binding: FragmentHistoryBinding
    private val historyvm: HistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showHistory()
    }

    fun showHistory(){
        historyvm.getHistory()
        historyvm.history.observe(this){
            if(it != null){
                binding.apply {
                    rvHistory.adapter = HistoryAdapter(it)
                    rvHistory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                }
            }
        }
    }


}