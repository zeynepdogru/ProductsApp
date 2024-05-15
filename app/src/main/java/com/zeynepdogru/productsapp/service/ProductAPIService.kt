package com.zeynepdogru.productsapp.service

import com.zeynepdogru.productsapp.model.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ProductAPIService {

    val api=Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(ProductAPI::class.java)

    fun getData(): Call<List<Product>>{
        return api.getProducts()
    }
}