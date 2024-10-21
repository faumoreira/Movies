package com.example.movies.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movies.ui.theme.MoviesTheme

@Composable
fun DetailsScreen(id: String) {
    Detail(id = id)
}

@Composable
fun Detail(id: String){
    Column {
        Text(
            text = "New page!! $id"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MoviesTheme {
        DetailsScreen(id = "teste")
    }
}