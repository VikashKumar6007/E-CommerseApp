package com.example.e_commerce


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.imageview.ShapeableImageView


class  CategoriesAdaptor(private val categorielist :ArrayList<CategoriesDataClass>):RecyclerView.Adapter<CategoriesAdaptor.CategoriesAdaptor>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdaptor {
        val itemView  = LayoutInflater.from(parent.context).inflate(R.layout.categories,parent,false)
        return CategoriesAdaptor(itemView)
    }

    override fun getItemCount(): Int {
       return categorielist.size
    }

    override fun onBindViewHolder(holder: CategoriesAdaptor, position: Int) {
        val currentIteam = categorielist[position]
        holder.titleImage.setImageResource(currentIteam.categoryImage)
    }


inner class CategoriesAdaptor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleImage: ImageView = itemView.findViewById(R.id.categories_img)

}

}