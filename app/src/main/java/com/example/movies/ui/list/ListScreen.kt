package com.example.movies.ui.list

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.movies.dto.MovieDetails
import com.example.movies.network.Constants
import com.example.movies.ui.theme.MoviesTheme

@Composable
fun ListScreen() {
    val listViewModel: ListViewModel = hiltViewModel()
    val movies = listViewModel.moviesFlow.collectAsState()
    movies.value?.results?.let { ListContext(movies = it) }
}

@Composable
fun ListContext(
    movies: List<MovieDetails?>,
) {
    LazyVerticalGrid(columns = GridCells.Adaptive(150.dp)) {
        items(movies) { movie ->
            AsyncImage(
                model = "${Constants.POSTER_IMAGE_BASE_URL}${movie?.posterPath}",
                contentDescription = null
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    MoviesTheme {
        ListContext(listOf())
    }
}