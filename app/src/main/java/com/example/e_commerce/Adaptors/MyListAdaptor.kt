package com.example.e_commerce.Adaptors

import Product
import android.content.Intent
import android.graphics.Bitmap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce.ProductDescriptionActivity
import com.example.e_commerce.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso


class MyListAdaptor(private val itemlist : ArrayList<Product>) :RecyclerView.Adapter<MyListAdaptor.MyListAdaptor>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListAdaptor {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyListAdaptor(itemView)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: MyListAdaptor, position: Int) {
        val currentItem = itemlist[position]
        Picasso.get().load(currentItem.thumbnail).into(holder.titleImage)
        holder.desc.text = currentItem.description
        holder.title.text = currentItem.brand
        Picasso.get().load(currentItem.thumbnail).into(holder.titleImage)
        holder.ratingBar.rating = currentItem.rating.toFloat()
        holder.price.text = currentItem.price.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProductDescriptionActivity::class.java)
            intent.putExtra("name",itemlist[position].title)
            intent.putExtra("images",itemlist[position].thumbnail)
            intent.putExtra("description",itemlist[position].description)
            intent.putExtra("rating",itemlist[position].rating)

            holder.itemView.context.startActivity(intent)

        }


    }
    class MyListAdaptor(itemView : View): RecyclerView.ViewHolder(itemView){
        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val desc :TextView = itemView.findViewById(R.id.productDescriptionTextView)
        val title:TextView = itemView.findViewById(R.id.productNameTextView)
        val ratingBar:RatingBar = itemView.findViewById(R.id.rating_list)
        val price:TextView = itemView.findViewById(R.id.price_list)

    }

}