package com.example.praproject.viewmodel

import android.provider.ContactsContract.Data
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.praproject.data.endpoint.DataUsersItem
import com.example.praproject.data.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: ViewModel() {
    private val _loginUser = MutableLiveData<List<DataUsersItem>?>()
    val loginUser: LiveData<List<DataUsersItem>?> = _loginUser

    fun loginUser(email: String, password: String) {
        RetrofitClient.instance.getAllUser().enqueue(object : Callback<List<DataUsersItem>> {
            override fun onResponse(
                call: Call<List<DataUsersItem>>,
                response: Response<List<DataUsersItem>>
            ) {
                if (response.isSuccessful) {
                    val userList = response.body()!!
                    var loginSuccess = false // Flag to track successful login

                    for (user in userList) {
                        if (user.email == email && user.password == password) {
                            loginSuccess = true
                            _loginUser.postValue(userList)
                            break // Exit the loop since login is successful
                        }
                    }

                    if (!loginSuccess) {
                        _loginUser.postValue(null)
                    }
                } else {
                    _loginUser.postValue(null)
                }
            }

            override fun onFailure(call: Call<List<DataUsersItem>>, t: Throwable) {
                _loginUser.postValue(null)
            }
        })
    }

}