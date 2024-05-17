package com.example.e_commerce

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerce.databinding.FragmentProfileBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class Profile : Fragment() {
  private lateinit var binding: FragmentProfileBinding
  private lateinit var firebaseAuth: FirebaseAuth
  private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()
        sharedPreferences = requireContext().getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)



        binding.btnSignOut.setOnClickListener {
           signOut()


        }

        return binding.root
    }
    private fun signOut() {
        firebaseAuth.signOut()
        setLoggedOut()
        navigateToSignUpActivity()
        requireActivity().finish()
    }

    private fun setLoggedOut() {
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", false)
        editor.apply()
    }

    private fun navigateToSignUpActivity() {
        val intent = Intent(requireContext(), Login::class.java)
        startActivity(intent)
    }


}