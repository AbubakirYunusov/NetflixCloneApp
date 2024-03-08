package com.example.netflixcloneapp.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.netflixcloneapp.R
import com.example.netflixcloneapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.home_screen_destination -> bottomNavigationVisibility(true)
                R.id.splashScreenFragment -> bottomNavigationVisibility(false)
            }
        }
    }

    private fun bottomNavigationVisibility(visible: Boolean) {
        binding.bottomNavigationView.visibility = if (visible) View.VISIBLE
        else View.GONE
    }
}