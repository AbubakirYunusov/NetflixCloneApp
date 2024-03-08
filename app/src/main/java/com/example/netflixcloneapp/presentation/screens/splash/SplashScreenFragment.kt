package com.example.netflixcloneapp.presentation.screens.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.netflixcloneapp.R
import com.example.netflixcloneapp.databinding.FragmentSplashScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashScreenFragment : Fragment() {

    private val binding: FragmentSplashScreenBinding by lazy {
        FragmentSplashScreenBinding.inflate(layoutInflater)
    }

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onEvent(SplashScreenEvent.onNavigateToMainGraphAfterTenSeconds)

        lifecycleScope.launch {
            viewModel.uiAction.collectLatest {
                when (it) {
                    SplashScreenAction.NavigationToMainGraph -> findNavController().navigate(R.id.nav_graph)
                }
            }
        }
    }
}
