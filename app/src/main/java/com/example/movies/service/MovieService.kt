package com.example.movies.service

import com.example.movies.dto.MovieDetails
import com.example.movies.dto.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("top_rated")
    suspend fun fetchMovies(): Response<MovieResponse>

    @GET("{movie_id}")
    suspend fun getDetail(
        @Path("movie_id") movieId: String,
        @Query("language") language: String = "en-US"
    ): Response<MovieDetails>
}