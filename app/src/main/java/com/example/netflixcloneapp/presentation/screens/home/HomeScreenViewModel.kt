package com.example.netflixcloneapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.damain.usecases.FetchPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val fetchPopularMoviesUseCase: FetchPopularMoviesUseCase,
) : ViewModel() {

    private val _uiAction: MutableSharedFlow<HomeScreenAction> = MutableSharedFlow()
    val uiAction: SharedFlow<HomeScreenAction> = _uiAction.asSharedFlow()

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            HomeScreenEvent.OnFetchPopularMovies -> onFetchPopularMovies()
        }
    }

    private fun onFetchPopularMovies() {
        viewModelScope.launch {
            val response = fetchPopularMoviesUseCase(page = 1)
            if (response.isSuccess) {
                _uiAction.emit(
                    HomeScreenAction.FetchedPopularMovies(
                        popularMovies = response.getOrNull().orEmpty()
                    )
                )
            }
        }
    }
}