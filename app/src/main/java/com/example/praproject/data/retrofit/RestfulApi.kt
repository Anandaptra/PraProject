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
import retrofit2.http.Path

interface RestfulApi {
    @GET("users")
    fun getAllUser(): Call<List<DataUsersItem>>

    @GET("DataFavourite")
    fun getAllFavourite(): Call<List<DataFavouriteItem>>
    @GET("news_update")
    fun getAllNewsUpdate(): Call<List<DataNewsUpdateItem>>
    @GET("DataCategory")
    fun getAllCategory(): Call<List<DataCategoryItem>>

    @GET("category_product/5/products")
    fun getAllProducts(): Call<List<DataProductsItem>>

    @GET("DataSliders")
    fun getAllSliders(): Call<List<DataSliderItem>>

    @POST("users")
    fun postDataUser(@Body request : User) : Call<DataUsersItem>
    @POST("DataTranshistory")
    fun postDataTranshistory(@Body request : Transhistory) : Call<DataTranshistoryItem>

    @GET("users/{id_users}/favourite")
    fun getFavouriteItem(@Path("id_users") id_users: Int) : Call<List<DataFavouriteItem>>

    @POST("users/{id_users}/favourite")
    fun postFavItem(@Path("id_users") id_users: Int, @Body fav: Favourite) : Call<DataFavouriteItem>

    @GET("users/{id_users}/cart")
    fun getCartItem(@Path("id_users") id_users: Int) : Call<List<DataCartItem>>
    @POST("users/{id_users}/cart")
    fun postCartItem(@Path("id_users") id_users: Int, @Body cart: Cart) : Call<DataCartItem>

    @GET("users/{id_users}/transhistory")
    fun geTranshistory(@Path("id_users") id_users: Int) : Call<List<DataTranshistoryItem>>
}