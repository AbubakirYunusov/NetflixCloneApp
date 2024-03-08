package com.example.netflixcloneapp.di

import com.example.damain.repository.MovieRepository
import com.example.data.remote.MovieServis
import com.example.data.repository.impl.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideMovieRepository(
        movieService: MovieServis
    ): MovieRepository = MovieRepositoryImpl(movieService)
}