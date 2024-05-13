package com.example.e_commerce

import ProductsResp
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.apiServices.Api
import com.example.e_commerce.apiServices.ApiClient
import com.example.e_commerce.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log


class Home : Fragment() {
    private lateinit var binding: FragmentHomeBinding
   private lateinit var newRecyclerView: RecyclerView
    private val TAG : String = "Check"
    private lateinit var newArrayList: ArrayList<ItemList>
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        newRecyclerView = binding.recyclerId
        newArrayList = ArrayList()


        newArrayList.add(ItemList(R.drawable.image))
        newArrayList.add(ItemList(R.drawable.men))
        newArrayList.add(ItemList(R.drawable.pic3))
        newArrayList.add(ItemList(R.drawable.home))

        newRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        newRecyclerView.adapter = MyListAdaptor(newArrayList)
         getAllComments()
        return binding.root
    }
    private fun getAllComments(){

        var api = ApiClient.api().getApi()

        api.enqueue(object : Callback<ProductsResp> {
            override fun onResponse(call: Call<ProductsResp>, response: Response<ProductsResp>) {
                if(response.isSuccessful){

                    var list = response.body()

                    Log.e("TAG",list.toString())

                }else{
                    Log.e(TAG, "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ProductsResp>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }

        })






    }


}

