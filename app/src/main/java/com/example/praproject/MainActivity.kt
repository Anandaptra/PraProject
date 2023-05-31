package com.example.praproject

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.praproject.databinding.ActivityMainBinding
import com.example.praproject.view.CartFragment
import com.example.praproject.view.FavouriteFragment
import com.example.praproject.view.HistoryFragment
import com.example.praproject.view.HomeFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFragment()

    }

    fun setFragment(){
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.favourite -> {
                    loadFragment(FavouriteFragment())
                    true
                }
                R.id.cart -> {
                    loadFragment(CartFragment())
                    true
                }
                R.id.transHistory -> {
                    loadFragment(HistoryFragment())
                    true
                }
                R.id.profile -> {
                    loadFragment(HomeFragment())
                    true
                }
                else -> {false}
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView,fragment)
        transaction.commit()
    }
}