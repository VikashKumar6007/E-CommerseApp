package com.example.e_commerce.Adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.R
import com.example.e_commerce.DataClass.favList

class FavoritesAdaptor(private val favroitsList: ArrayList<favList>):RecyclerView.Adapter<FavoritesAdaptor.FavoritesAdaptor>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesAdaptor {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fav_recyclar_list,parent,false)
        return FavoritesAdaptor(itemView)
    }

    override fun getItemCount(): Int {
        return favroitsList.size
    }

    override fun onBindViewHolder(holder: FavoritesAdaptor, position: Int) {
        val currentItem = favroitsList[position]
        holder.favImage.setImageResource(currentItem.favImage)
    }
    inner class FavoritesAdaptor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val favImage: ImageView = itemView.findViewById(R.id.fav_img)


    }
}