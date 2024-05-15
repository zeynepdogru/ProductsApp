package com.zeynepdogru.productsapp.service

import com.zeynepdogru.productsapp.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductAPI {
   // https://fakestoreapi.com/products
    @GET("products")
    fun getProducts(): Call<List<Product>>

}