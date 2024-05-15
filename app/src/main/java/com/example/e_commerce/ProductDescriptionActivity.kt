package com.example.e_commerce


import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.e_commerce.databinding.ActivityProductDescriptionBinding
import com.squareup.picasso.Picasso


class ProductDescriptionActivity : AppCompatActivity() {


    private lateinit var binding:ActivityProductDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductDescriptionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val list = resources.getStringArray(R.array.Quantity)
        val spinner : Spinner = findViewById(R.id.spinner_view)
        spinner.adapter= ArrayAdapter(this,R.layout.menu_list,R.id.menu_listt,list)

        spinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                Toast.makeText(this@ProductDescriptionActivity,list[position],Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

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