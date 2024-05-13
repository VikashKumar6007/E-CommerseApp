package com.example.e_commerce

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyListAdaptor(private val itemlist : ArrayList<ItemList>) :RecyclerView.Adapter<MyListAdaptor.MyListAdaptor>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListAdaptor {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyListAdaptor(itemView)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: MyListAdaptor, position: Int) {
        val currentItem = itemlist[position]
        holder.titleImage.setImageResource(currentItem.titleImage)

    }
    class MyListAdaptor(itemView : View): RecyclerView.ViewHolder(itemView){

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)

    }

}