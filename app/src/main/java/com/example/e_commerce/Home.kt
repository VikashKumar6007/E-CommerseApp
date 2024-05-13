package com.example.e_commerce

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.databinding.ActivityMainBinding
import com.example.e_commerce.databinding.FragmentHomeBinding


class Home : Fragment() {
    private lateinit var binding: FragmentHomeBinding
   private lateinit var newRecyclerView: RecyclerView

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

        return binding.root
    }


}