package com.zeynepdogru.productsapp.model

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName

data class Product(
    val id: Int,
    @SerializedName("title")
    val title: String,
    val price: Int,
    val description: String,
    val category: String,
    @SerializedName("image")
    val productImage: String,
    val rating: Rating // Rating sınıfını buraya dahil ediyoruz
)

data class Rating(
    val rate: Double,
    val count: Int
)

