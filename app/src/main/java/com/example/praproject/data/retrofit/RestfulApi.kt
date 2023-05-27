package com.example.praproject.data.retrofit

import com.example.praproject.data.endpoint.*
import com.example.praproject.dataclass.Cart
import com.example.praproject.dataclass.Favourite
import com.example.praproject.dataclass.Transhistory
import com.example.praproject.dataclass.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RestfulApi {
    @GET("users")
    fun getAllUser(): Call<List<DataUsersItem>>
    @GET("DataTranshistory")
    fun getAllTranshistory(): Call<List<DataTranshistoryItem>>
    @GET("DataCart")
    fun getAllCart(): Call<List<DataCartItem>>
    @GET("DataFavourite")
    fun getAllFavourite(): Call<List<DataFavouriteItem>>
    @GET("DataNewsUpdate")
    fun getAllNewsUpdate(): Call<List<DataNewsUpdateItem>>
    @GET("DataCategory")
    fun getAllCategory(): Call<List<DataCategoryItem>>

    @GET("DataProducts")
    fun getAllProducts(): Call<List<DataProductsItem>>

    @GET("DataSliders")
    fun getAllSliders(): Call<List<DataSliderItem>>

    @POST("users")
    fun postDataUser(@Body request : User) : Call<DataUsersItem>
    @POST("DataTranshistory")
    fun postDataTranshistory(@Body request : Transhistory) : Call<DataTranshistoryItem>
    @POST("DataCart")
    fun postDataCart(@Body request : Cart) : Call<DataCartItem>
    @POST("DataFavourite")
    fun postDataUser(@Body request : Favourite) : Call<DataFavouriteItem>


}