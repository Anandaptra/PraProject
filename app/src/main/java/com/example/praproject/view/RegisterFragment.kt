package com.example.praproject.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.praproject.R
import com.example.praproject.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnRegis.setOnClickListener {
            registAccount()
        }
    }

    private fun registAccount() {
        val username = binding.etNama.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPw.text.toString()


        if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(context, "Registration Success", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                } else {
                    Toast.makeText(context, "Registration Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }


}