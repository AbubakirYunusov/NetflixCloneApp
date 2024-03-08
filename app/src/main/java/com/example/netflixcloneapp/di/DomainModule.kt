package com.example.netflixcloneapp.di

import com.example.damain.repository.MovieRepository
import com.example.damain.usecases.FetchPopularMoviesUseCase
import com.example.damain.usecases.FetchPopularMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideFetchPopularMovieUseCase(
        repository: MovieRepository
    ) : FetchPopularMoviesUseCase = FetchPopularMoviesUseCaseImpl(repository)
}