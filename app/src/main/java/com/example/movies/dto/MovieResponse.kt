package com.example.movies.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
    val page: Int,
    val results: List<MovieDetails>,
    val total_pages: Int,
    val total_results: Int
)

@JsonClass(generateAdapter = true)
data class DateRange(
    val maximum: String,
    val minimum: String
)