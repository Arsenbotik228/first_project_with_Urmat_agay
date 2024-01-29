package com.myself223.card

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.myself223.card.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navHostFragment.navController
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

    fun hideBottomNav() {
        binding.bottomNav.visibility = View.GONE
    }

    fun showBottomNav() {
        binding.bottomNav.visibility = View.VISIBLE
    }
}
