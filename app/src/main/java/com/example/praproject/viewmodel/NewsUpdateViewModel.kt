package com.example.praproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praproject.data.endpoint.DataNewsUpdateItem
import com.example.praproject.data.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsUpdateViewModel : ViewModel() {
    var liveDataNewsUpdate: MutableLiveData<List<DataNewsUpdateItem>> = MutableLiveData()

    init {
        liveDataNewsUpdate = MutableLiveData()
    }

    fun callApiNews() {
        RetrofitClient.instance.getAllNewsUpdate().enqueue(object : Callback<List<DataNewsUpdateItem>> {
            override fun onResponse(
                call: Call<List<DataNewsUpdateItem>>,
                response: Response<List<DataNewsUpdateItem>>
            ) {
                if (response.isSuccessful) {
                    liveDataNewsUpdate.postValue(response.body())
                } else {
                    liveDataNewsUpdate.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<DataNewsUpdateItem>>, t: Throwable) {
                liveDataNewsUpdate.postValue(null)
            }
        })
    }
}