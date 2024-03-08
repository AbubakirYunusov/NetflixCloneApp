package com.example.damain.usecases

import com.example.damain.models.MovieDomainModel

interface FetchPopularMoviesUseCase {

    suspend operator fun invoke(
        page: Int
    ) : Result<List<MovieDomainModel>>
}