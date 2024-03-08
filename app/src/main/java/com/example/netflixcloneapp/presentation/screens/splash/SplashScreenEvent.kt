package com.example.netflixcloneapp.presentation.screens.splash

sealed interface SplashScreenEvent {
    data object onNavigateToMainGraphAfterTenSeconds : SplashScreenEvent
}