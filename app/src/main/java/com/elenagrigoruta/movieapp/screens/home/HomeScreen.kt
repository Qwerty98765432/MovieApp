package com.elenagrigoruta.movieapp.screens.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.elenagrigoruta.movieapp.model.Movie
import com.elenagrigoruta.movieapp.model.getMovies
import com.elenagrigoruta.movieapp.navigation.MovieScreens
import com.elenagrigoruta.movieapp.widgets.MovieRow


@Composable
fun homeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.LightGray,
                elevation = 5.dp
            ) {
                Text(text = "Movies")
            }
        },
    )
    {
        mainContent(navController = navController)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun mainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies())
 {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailScreen.name + "/$movie")
                }
            }

        }
    }
}




