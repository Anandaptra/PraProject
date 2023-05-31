package com.example.praproject.dataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Detail(
    val imagePath:String,
    val title:String,
    val price:String,
    val overview:String,
    val Date:String

): Parcelable
