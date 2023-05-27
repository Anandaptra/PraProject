package com.example.praproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praproject.data.endpoint.DataUsersItem
import com.example.praproject.data.retrofit.RetrofitClient
import com.example.praproject.dataclass.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {
    private val _postDataUser = MutableLiveData<DataUsersItem>()
    val postDataUser: LiveData<DataUsersItem> = _postDataUser


    fun addDataUser(user: User) {
        RetrofitClient.instance.postDataUser(user).enqueue(object :
            Callback<DataUsersItem> {
            override fun onResponse(
                call: Call<DataUsersItem>,
                response: Response<DataUsersItem>
            ) {
                if (response.isSuccessful) {
                    _postDataUser.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<DataUsersItem>, t: Throwable) {
                throw t
            }
        })
    }
}