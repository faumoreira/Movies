package com.example.movies.ui.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.dto.MovieResponse
import com.example.movies.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _moviesFlow = MutableStateFlow<MovieResponse?>(null)
    val moviesFlow: StateFlow<MovieResponse?> = _moviesFlow

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            try {
                val newItem = movieRepository.fetchMovies()
                _moviesFlow.value = newItem.body()
                Log.e("MovieListViewModel", newItem.toString())
            } catch (e: Exception) {
                // Handle exceptions, if any
                Log.e("MovieListViewModel", "Error fetching details",e)
            }
        }
    }
}