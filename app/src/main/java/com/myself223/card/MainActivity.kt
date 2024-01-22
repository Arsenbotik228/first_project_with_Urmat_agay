package com.myself223.card

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.myself223.card.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private val navController : NavController by lazy {
       val navHostFragment =
           supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
       navHostFragment.navController

   }
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initBottomNav()

    }

    private fun initBottomNav() {
        binding.bottomNav.apply {
            setupWithNavController(navController)
            itemIconTintList = null
         }
    }
}