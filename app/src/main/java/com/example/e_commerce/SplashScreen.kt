package com.example.e_commerce

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.e_commerce.databinding.ActivitySplashScreenBinding


class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)

        if (isLoggedIn()) {
            navigateToSignUpActivity()
        } else  {
            navigateToMainActivity()
        }

    }


    private fun isLoggedIn(): Boolean {

        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToSignUpActivity() {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
        finish()
    }

    }
