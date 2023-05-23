package com.example.praproject.data.endpoint


import com.google.gson.annotations.SerializedName

data class DataSliderItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String
)