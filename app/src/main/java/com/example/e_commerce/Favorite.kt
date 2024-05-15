package com.example.e_commerce

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.Adaptors.FavoritesAdaptor
import com.example.e_commerce.DataClass.favList
import com.example.e_commerce.databinding.FragmentFavoriteBinding

class Favorite : Fragment() {
    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<favList>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFavoriteBinding.inflate(layoutInflater)

        newRecyclerView = binding.favoritsRecycler
        newArrayList = ArrayList()

        newArrayList.add(favList(R.drawable.fav_pic1))
        newArrayList.add(favList(R.drawable.fav_pic2))
        newArrayList.add(favList(R.drawable.fav_pic3))
        newArrayList.add(favList(R.drawable.fav_pic4))


        newRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        newRecyclerView.adapter = FavoritesAdaptor(newArrayList)

        return binding.root
    }

}