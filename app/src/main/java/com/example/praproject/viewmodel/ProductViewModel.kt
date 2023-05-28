package com.example.praproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praproject.data.endpoint.DataNewsUpdateItem
import com.example.praproject.data.endpoint.DataProductsItem
import com.example.praproject.data.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {
    var liveProduct: MutableLiveData<List<DataProductsItem>?> = MutableLiveData()

    init {
        liveProduct = MutableLiveData()
    }

    fun getProduct() {
        RetrofitClient.instance.getAllProducts().enqueue(object : Callback<List<DataProductsItem>> {
            override fun onResponse(
                call: Call<List<DataProductsItem>>,
                response: Response<List<DataProductsItem>>
            ) {
                if (response.isSuccessful) {
                    liveProduct.postValue(response.body())
                } else {
                    liveProduct.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<DataProductsItem>>, t: Throwable) {
                liveProduct.postValue(null)
            }
        })
    }
}