package com.example.e_commerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.e_commerce.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val TAG : String = "Check"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replacefragement(Home())
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->replacefragement(Home())
                R.id.shop -> replacefragement(Shop())
                R.id.bag ->replacefragement(Bag())
                R.id.favorites ->replacefragement(Favorite())
                R.id.profile -> replacefragement(Profile())
                else -> {

                }
            }
            true
        }

    }
    private fun replacefragement(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }







}