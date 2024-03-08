package com.example.damain.usecases

import com.example.damain.models.MovieDomainModel
import com.example.damain.repository.MovieRepository

class FetchPopularMoviesUseCaseImpl(
    private val repository: MovieRepository
) : FetchPopularMoviesUseCase {
    override suspend fun invoke(
        page: Int
    ): Result<List<MovieDomainModel>> {
        return repository.fetchPopularMovie(page)
    }
}