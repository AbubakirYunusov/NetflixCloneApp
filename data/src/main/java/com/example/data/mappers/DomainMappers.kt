package com.example.data.mappers

import com.example.damain.models.MovieDomainModel
import com.example.data.models.MovieCloudModel
import com.example.data.utils.Constants.POSTER_PATH_URL

fun MovieCloudModel.toDomain() = MovieDomainModel(
    posterPath = "$POSTER_PATH_URL${this.posterPath}",
    adult = this.adult,
    overview = this.overview,
    releaseDate = this.releaseDate,
    id = this.id,
    originalTitle = this.originalTitle,
    originalLanguage = this.originalLanguage,
    title = this.title,
    backdropPath = "$POSTER_PATH_URL${this.backdropPath}",
    popularity = this.popularity,
    voteCount = this.voteCount,
    video = this.video,
    rating = this.rating,
    genres = this.genres
)