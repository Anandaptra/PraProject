package com.example.praproject.data.retrofit

import com.example.praproject.data.endpoint.DataUsersItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    @GET("DataUser")
    fun getAllNews(): Call<List<DataUsersItem>>
}