package com.zeynepdogru.productsapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zeynepdogru.productsapp.model.Product
import com.zeynepdogru.productsapp.service.ProductAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel: ViewModel() {

    private val productAPI = ProductAPIService()

    val productData = MutableLiveData<List<Product>>()
    val productError = MutableLiveData<Boolean>()


    fun getDataFromAPI() {
        productAPI.getData().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                productData.value=response.body()
                productError.value=false
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
               productError.value=true
                Log.e("RetrofitError", t.message.toString())
            }


        })


    }
}