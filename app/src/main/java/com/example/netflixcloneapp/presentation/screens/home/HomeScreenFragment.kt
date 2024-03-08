package com.example.netflixcloneapp.presentation.screens.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.netflixcloneapp.databinding.FragmentHomeScreenBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeScreenFragment : Fragment() {

    private val binding: FragmentHomeScreenBinding by lazy {
        FragmentHomeScreenBinding.inflate(layoutInflater)
    }

    private val viewModel: HomeScreenViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onEvent(HomeScreenEvent.OnFetchPopularMovies)
        lifecycleScope.launch {
            viewModel.uiAction.collectLatest {
                when (it) {
                    is HomeScreenAction.FetchedPopularMovies -> {
                        Log.d("AAA","movies = $it")
                    }
                }
            }
        }
    }
}