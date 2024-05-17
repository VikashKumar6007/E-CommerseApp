package com.example.e_commerce

import Product
import ProductsResp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.Adaptors.MyListAdaptor
import com.example.e_commerce.apiServices.ApiClient
import com.example.e_commerce.databinding.FragmentHomeBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Home : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var newRecyclerView: RecyclerView

    private val TAG: String = "Check"
    private var newArrayList: ArrayList<Product> = ArrayList()
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        getProducts()
        return binding.root

    }

    private fun setRecy() {
        newRecyclerView = binding.recyclerId
        newRecyclerView.layoutManager = GridLayoutManager(this@Home.requireActivity(), 2, LinearLayoutManager.VERTICAL, false)
        newRecyclerView.adapter = MyListAdaptor(newArrayList)


    }

    private fun getProducts() {
        binding.progress.progcc.visibility = View.VISIBLE

        var api = ApiClient.api().getApi()

        api.enqueue(object : Callback<ProductsResp> {
            override fun onResponse(call: Call<ProductsResp>, response: Response<ProductsResp>) {
                if (response.isSuccessful) {

                    var list = response.body()

                    newArrayList = list?.products as ArrayList<Product>

                    Handler(Looper.getMainLooper()).postDelayed({
                        binding.progress.progcc.visibility = View.GONE
                        setRecy()

                    }, 3000)

                } else {
                    Log.e(TAG, "Error: ${response.code()}")
                    binding.progress.progcc.visibility = View.GONE

                }
            }

            override fun onFailure(call: Call<ProductsResp>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
                binding.progress.progcc.visibility = View.GONE
            }

        })

    }


}

