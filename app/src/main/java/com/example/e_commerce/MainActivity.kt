package com.example.e_commerce

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.e_commerce.Adaptors.PrefManager
import com.example.e_commerce.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var sharedPreferences:SharedPreferences

    private val TAG : String = "Check"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()
//        sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)
//
//        if (!isLoggedIn()) {
//            Log.d("MainActivity", "User is not logged in, navigating to LoginActivity")
//            navigateToLoginActivity()
//        } else {
//            Log.d("MainActivity", "User is logged in, proceeding with MainActivity")
//        }



//        init()
//        checkLogin()
////        setUpUI()

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

//    private fun isLoggedIn(): Boolean {
//        return sharedPreferences.getBoolean("isLoggedIn", false)
//    }
//
//    private fun navigateToLoginActivity() {
//        val intent = Intent(this, Login::class.java)
//        startActivity(intent)
//        finish()
//    }









//    private fun init(){
//        prefManager = PrefManager(this)
//          username= prefManager.getUsername().toString()
//
//
//    }
//    private fun checkLogin(){
//        if (prefManager.isLogin() ==false){
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }


}