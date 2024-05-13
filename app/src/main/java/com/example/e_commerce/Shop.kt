package com.example.e_commerce

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.databinding.FragmentShopBinding
import com.google.android.material.tabs.TabLayout


class Shop : Fragment() {
    private lateinit var binding: FragmentShopBinding
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<CategoriesDataClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShopBinding.inflate(layoutInflater)

        newRecyclerView = binding.categoriesRecycler
        newArrayList = ArrayList()

        newArrayList.add(CategoriesDataClass(R.drawable.new_imagepng))
        newArrayList.add(CategoriesDataClass(R.drawable.catergerios_pic2))
        newArrayList.add(CategoriesDataClass(R.drawable.catergreio_pic3))
        newArrayList.add(CategoriesDataClass(R.drawable.catergories_pic4))

        newRecyclerView.layoutManager = LinearLayoutManager(requireContext())
       newRecyclerView.adapter = CategoriesAdaptor(newArrayList)
        return binding.root
    }


}