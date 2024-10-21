package com.example.movies.repository

import com.example.movies.service.MovieService
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: MovieService
) {
    suspend fun fetchMovies() = apiService.fetchMovies()
    suspend fun getDetail(movieId: String) = apiService.getDetail(movieId)
}