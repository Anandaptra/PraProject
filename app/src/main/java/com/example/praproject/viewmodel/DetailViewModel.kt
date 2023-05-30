package com.example.praproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praproject.data.endpoint.DataCartItem
import com.example.praproject.data.endpoint.DataFavouriteItem
import com.example.praproject.data.retrofit.RetrofitClient
import com.example.praproject.dataclass.Cart
import com.example.praproject.dataclass.Favourite
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {
    private val _addFav = MutableLiveData<DataFavouriteItem?>()
    val addFav: LiveData<DataFavouriteItem?> = _addFav

    private val _addCart = MutableLiveData<DataCartItem?>()
    val addCart: LiveData<DataCartItem?> = _addCart

    fun postFav(fav: Favourite){
        RetrofitClient.instance.postFavItem(1, fav).enqueue(object : Callback<DataFavouriteItem> {
            override fun onResponse(
                call: Call<DataFavouriteItem>,
                response: Response<DataFavouriteItem>
            ) {
                if(response.isSuccessful) _addFav.postValue(response.body())
            }

            override fun onFailure(call: Call<DataFavouriteItem>, t: Throwable) {
                _addFav.postValue(null)
            }

        })
    }

    fun postCart(cart: Cart){
        RetrofitClient.instance.postCartItem(1, cart).enqueue(object : Callback<DataCartItem> {
            override fun onResponse(
                call: Call<DataCartItem>,
                response: Response<DataCartItem>
            ) {
                if(response.isSuccessful) _addCart.postValue(response.body())
            }

            override fun onFailure(call: Call<DataCartItem>, t: Throwable) {
                _addCart.postValue(null)
            }

        })
    }
}