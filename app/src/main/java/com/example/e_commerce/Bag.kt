package com.example.e_commerce

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.databinding.FragmentBagBinding

class Bag : Fragment() {
   private lateinit var binding:FragmentBagBinding
   private lateinit var newRecyclerView: RecyclerView
   private lateinit var newArrayList: ArrayList<bag_item>




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBagBinding.inflate(layoutInflater)

        newRecyclerView = binding.recyclerBag
        newArrayList = ArrayList()

        newArrayList.add(bag_item(R.drawable.new_imagepng))
        newArrayList.add(bag_item(R.drawable.bag_pic))





        newRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        newRecyclerView.adapter= BagItem(newArrayList)

        return binding.root
    }


}