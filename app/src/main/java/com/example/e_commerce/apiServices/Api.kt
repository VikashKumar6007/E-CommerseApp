package com.example.e_commerce.apiServices


import ProductsResp
import retrofit2.Call
import retrofit2.http.GET


interface Api {

    @GET("products")
    fun getApi(): Call<ProductsResp>


}
