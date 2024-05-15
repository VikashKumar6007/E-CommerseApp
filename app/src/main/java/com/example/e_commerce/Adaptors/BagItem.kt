package com.example.e_commerce.Adaptors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.R
import com.example.e_commerce.DataClass.bag_item

class BagItem (private  val bagItem: ArrayList<bag_item>):RecyclerView.Adapter<BagItem.BagItem>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BagItem {
        val itemView  = LayoutInflater.from(parent.context).inflate(R.layout.bag_items,parent,false)
        return BagItem(itemView)
    }

    override fun getItemCount(): Int {
       return bagItem.size
    }

    override fun onBindViewHolder(holder: BagItem, position: Int) {
        val currentIteam = bagItem[position]
        holder.titleImage.setImageResource(currentIteam.bagImage)
    }


    inner class BagItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ImageView = itemView.findViewById(R.id.bag_img)
    }
}