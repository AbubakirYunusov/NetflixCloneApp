package com.example.netflixcloneapp.presentation.screens.splash

sealed interface SplashScreenAction {
    data object NavigationToMainGraph : SplashScreenAction
}