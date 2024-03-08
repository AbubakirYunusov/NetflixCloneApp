package com.example.netflixcloneapp.presentation.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor () : ViewModel() {

    private val _uiAction: MutableSharedFlow<SplashScreenAction> = MutableSharedFlow()
    val uiAction: SharedFlow<SplashScreenAction> = _uiAction.asSharedFlow()

    fun onEvent(splashScreenEvent: SplashScreenEvent) {
        when (splashScreenEvent) {
            SplashScreenEvent.onNavigateToMainGraphAfterTenSeconds -> enNavigateToMainGraphAfterTenSeconds()
        }
    }

    private fun enNavigateToMainGraphAfterTenSeconds() {
        viewModelScope.launch {
            delay(3_000L)
            _uiAction.emit(SplashScreenAction.NavigationToMainGraph)
        }
    }
}