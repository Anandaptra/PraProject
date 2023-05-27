package com.example.praproject.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.praproject.R
import com.example.praproject.databinding.FragmentLoginBinding
import com.example.praproject.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private val loginVM: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()


        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.btnSignin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if(email.isEmpty() && password.isEmpty()){
                Toast.makeText(requireContext(), "Isi field terlebih dahulu", Toast.LENGTH_SHORT).show()
            }else{
                loginResponse(email, password)
            }
        }
    }

    fun loginResponse(email: String, password: String){
        loginVM.loginUser(email, password)
        loginVM.loginUser.observe(this){
            if(it != null){
                Toast.makeText(requireContext(), "Login Berhasil", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Login Gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }
}