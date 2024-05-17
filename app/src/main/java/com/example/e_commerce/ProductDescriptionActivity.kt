package com.example.e_commerce


import Product


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import android.view.View
import android.widget.AdapterView

import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner

import androidx.recyclerview.widget.RecyclerView

import com.example.e_commerce.apiServices.ApiClient
import com.example.e_commerce.databinding.ActivityProductDescriptionBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductDescriptionActivity : AppCompatActivity() {

    private lateinit var binding:ActivityProductDescriptionBinding
    private lateinit var newRecyclerView: RecyclerView
    private  var newArrayList: ArrayList<Product> = ArrayList()
    private val TAG: String = "Check"

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductDescriptionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val list = resources.getStringArray(R.array.Quantity)
        val spinner : Spinner = findViewById(R.id.spinner_view)
        spinner.adapter= ArrayAdapter(this,R.layout.menu_list,R.id.menu_listt,list)

        spinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
//                Toast.makeText(this@ProductDescriptionActivity,list[position],Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        getProducts()

    }
    private fun getProducts() {

        val id = intent.getIntExtra("id",1)

        var api = ApiClient.api().getPostApi(id)

        api.enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if (response.isSuccessful) {

                    binding.prodDesc.desc.text = response.body()?.description
                    binding.prodDesc.productId.text = response.body()?.brand
                    Picasso.get().load(response.body()?.thumbnail).into(binding.prodDesc.detailsImg)
                    binding.prodDesc.etPrice.text = response.body()?.price.toString()

                } else {
                    Log.e(TAG, "Error: ${response.code()}")

                }
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }

        })

    }


}