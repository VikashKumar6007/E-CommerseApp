package com.example.e_commerce

import android.content.Intent
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnSignOut.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(requireContext(), SignUp::class.java))
            requireActivity().finish()


        }

        return binding.root
    }


}