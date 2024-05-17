package com.example.e_commerce.apiServices


import Product
import ProductsResp
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface Api {
    @GET("products")
    fun getApi(): Call<ProductsResp>
    @GET("products/{post_id}")
    fun getPostApi(@Path("post_id") postId:Int):Call<Product>;


}
