package com.example.praproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praproject.data.endpoint.DataNewsUpdateItem
import com.example.praproject.data.endpoint.DataSliderItem
import com.example.praproject.data.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    var liveSlide: MutableLiveData<List<DataSliderItem>> = MutableLiveData()

    fun getSlider(){
        RetrofitClient.instance.getAllSliders().enqueue(object : Callback<List<DataSliderItem>> {
            override fun onResponse(
                call: Call<List<DataSliderItem>>,
                response: Response<List<DataSliderItem>>

            ) {
                if (response.isSuccessful) {
                    liveSlide.postValue(response.body())
                } else {
                    liveSlide.postValue(emptyList())
                }
            }

            override fun onFailure(call: Call<List<DataSliderItem>>, t: Throwable) {
                liveSlide.postValue(emptyList())
            }
        })
    }
}