package com.example.damain.repository

import com.example.damain.models.MovieDomainModel

interface MovieRepository {

    suspend fun fetchPopularMovie(
        page: Int
    ): Result<List<MovieDomainModel>>

    suspend fun fetchUpcomingMovie(
        page: Int
    ): Result<List<MovieDomainModel>>
}