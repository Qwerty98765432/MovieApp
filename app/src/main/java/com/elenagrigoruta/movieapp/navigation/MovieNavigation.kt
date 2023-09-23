package com.elenagrigoruta.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.elenagrigoruta.movieapp.screens.home.homeScreen
import com.elenagrigoruta.movieapp.screens.home.details.detailsScreen

@Composable
fun movieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {

        composable(MovieScreens.HomeScreen.name) {
            //here we pass where this should lead us to
            homeScreen(navController = navController)
        }

        composable(
            MovieScreens.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            detailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie"))
        }
    }
}