package com.example.movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movies.ui.details.DetailsScreen
import com.example.movies.ui.list.ListScreen
import com.example.movies.ui.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieApp()
        }
    }
}

@Composable
fun MovieApp() {
    MoviesTheme {
        val navController = rememberNavController()
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "list",
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = "list") {
                    ListScreen()
                }
                composable(route = "details/{id}"){ navBackStackEntry ->
                    val id = navBackStackEntry.arguments?.getString("id")
                    /* We check if it's not null */
                    id?.let { id->
                        DetailsScreen(id = id)
                    }
                }
            }
        }
    }
}