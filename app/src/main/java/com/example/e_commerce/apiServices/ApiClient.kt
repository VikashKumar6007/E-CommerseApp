package com.example.e_commerce.apiServices

import Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object ApiClient {

    var BaseUrl = "https://dummyjson.com/"

    fun api():Api{
        val api = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)

        return api
    }
}