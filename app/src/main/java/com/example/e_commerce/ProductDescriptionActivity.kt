package com.example.e_commerce


import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.e_commerce.databinding.ActivityProductDescriptionBinding
import com.squareup.picasso.Picasso


class ProductDescriptionActivity : AppCompatActivity() {


    private lateinit var binding:ActivityProductDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductDescriptionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val size = resources.getStringArray(R.array.Quantity)
        val arrayAdapter = ArrayAdapter(this,R.layout.menu_list,size)


        binding.autoComplet.setAdapter(arrayAdapter)
            val title = intent.getStringExtra("name")
            val imageUrl = intent.getStringExtra("images")
            val desc = intent.getStringExtra("description")
            val rating = intent.getFloatExtra("rating", 3F)



            binding.productId.text = title.toString()
             binding.descId.text = desc.toString()
            Picasso.get().load(imageUrl).into(binding.detailsImg)
            binding.rating.rating = rating


    }


}