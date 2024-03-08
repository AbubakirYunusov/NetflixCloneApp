package com.example.netflixcloneapp.presentation.screens.home

sealed interface HomeScreenEvent {

    data object OnFetchPopularMovies : HomeScreenEvent
}