package com.example.netflixcloneapp.presentation.screens.home

import com.example.damain.models.MovieDomainModel

sealed interface HomeScreenAction {

    data class FetchedPopularMovies(
        val popularMovies: List<MovieDomainModel>
    ) : HomeScreenAction
}