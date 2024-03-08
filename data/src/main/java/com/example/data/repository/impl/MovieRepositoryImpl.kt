package com.example.data.repository.impl

import com.example.damain.models.MovieDomainModel
import com.example.damain.repository.MovieRepository
import com.example.data.mappers.toDomain
import com.example.data.models.MovieResponseCloudModel
import com.example.data.remote.MovieServis
import retrofit2.Response
import java.util.concurrent.CancellationException
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieServis
) : MovieRepository {


    override suspend fun fetchPopularMovie(
        page: Int
    ): Result<List<MovieDomainModel>> =
        sendRequestService(model = movieService.getPopularMovies(page = page))


    override suspend fun fetchUpcomingMovie(
        page: Int
    ): Result<List<MovieDomainModel>> =
        sendRequestService(model = movieService.getUpcomingMovies(page = page))

    private fun sendRequestService(model: Response<MovieResponseCloudModel>): Result<List<MovieDomainModel>> {
        return try {
            if (model.isSuccessful) {
                return Result.success(
                    model.body()?.movies?.map {
                        it.toDomain()
                    }.orEmpty()
                )
            } else Result.failure(Throwable())
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            throw e
        }
    }
}