package com.example.praproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praproject.data.endpoint.DataFavouriteItem
import com.example.praproject.data.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavouriteViewModel: ViewModel() {
    private val _favourite = MutableLiveData<List<DataFavouriteItem>?>()
    val favourite: LiveData<List<DataFavouriteItem>?> = _favourite

    fun getFavouriteItem(){
        RetrofitClient.instance.getFavouriteItem(1).enqueue(object :
            Callback<List<DataFavouriteItem>> {
            override fun onResponse(
                call: Call<List<DataFavouriteItem>>,
                response: Response<List<DataFavouriteItem>>
            ) {
                if(response.isSuccessful){
                    _favourite.postValue(response.body())
                }else{
                    _favourite.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<DataFavouriteItem>>, t: Throwable) {
                _favourite.postValue(null)
            }

        })
    }
}