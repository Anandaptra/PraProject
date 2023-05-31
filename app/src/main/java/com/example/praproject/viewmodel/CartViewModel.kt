package com.example.praproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praproject.data.endpoint.DataCartItem
import com.example.praproject.data.endpoint.DataFavouriteItem
import com.example.praproject.data.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartViewModel : ViewModel() {

    private val _cart = MutableLiveData<List<DataCartItem>?>()
    val cart: LiveData<List<DataCartItem>?> = _cart

    fun getCart(){
        RetrofitClient.instance.getCartItem(1).enqueue(object :
            Callback<List<DataCartItem>> {
            override fun onResponse(
                call: Call<List<DataCartItem>>,
                response: Response<List<DataCartItem>>
            ) {
                if(response.isSuccessful){
                    _cart.postValue(response.body())
                }else{
                    _cart.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<DataCartItem>>, t: Throwable) {
                _cart.postValue(null)
            }

        })
    }
}