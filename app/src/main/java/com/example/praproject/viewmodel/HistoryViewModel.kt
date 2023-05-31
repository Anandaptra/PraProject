package com.example.praproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praproject.data.endpoint.DataCartItem
import com.example.praproject.data.endpoint.DataTranshistoryItem
import com.example.praproject.data.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HistoryViewModel: ViewModel() {
    private val _history = MutableLiveData<List<DataTranshistoryItem>?>()
    val history: LiveData<List<DataTranshistoryItem>?> = _history

    fun getHistory(){
        RetrofitClient.instance.geTranshistory(1).enqueue(object :
            Callback<List<DataTranshistoryItem>> {
            override fun onResponse(
                call: Call<List<DataTranshistoryItem>>,
                response: Response<List<DataTranshistoryItem>>
            ) {
                if(response.isSuccessful){
                    _history.postValue(response.body())
                }else{
                    _history.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<DataTranshistoryItem>>, t: Throwable) {
                _history.postValue(null)
            }

        })
    }
}