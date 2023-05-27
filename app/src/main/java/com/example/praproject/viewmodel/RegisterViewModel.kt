package com.example.praproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praproject.data.endpoint.DataUsersItem
import com.example.praproject.data.retrofit.RetrofitClient
import com.example.praproject.dataclass.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {

    lateinit var postDataUser : MutableLiveData<DataUsersItem>

    init {
        postDataUser = MutableLiveData()
    }

    fun postUser () : MutableLiveData<DataUsersItem> {
        return postDataUser
    }

    fun addDataUser(name : String, email : String, password : String, image : String) {
        RetrofitClient.instance.postDataUser(User(name , email, password, image)).enqueue(object :
            Callback<DataUsersItem> {
            override fun onResponse(
                call: Call<DataUsersItem>,
                response: Response<DataUsersItem>
            ) {
                if (response.isSuccessful) {
                    postDataUser.postValue(response.body())
                } else {
                    postDataUser.postValue(null)
                }
            }

            override fun onFailure(call: Call<DataUsersItem>, t: Throwable) {
                postDataUser.postValue(null)
            }
        })
    }
}