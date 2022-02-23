package com.example.onetwotriptest.presentation.screens.main_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.onetwotriptest.core.Screens
import com.example.onetwotriptest.presentation.screens.firstScreen.FirstScreen
import com.example.onetwotriptest.presentation.screens.flights_list_screen.FlightsListScreen
import com.example.onetwotriptest.presentation.screens.flights_list_screen.FlightsListScreenViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = Screens.FirstScreen.route) {
        composable(Screens.FirstScreen.route) {
            FirstScreen(navController = navController)
        }
        composable(Screens.FlightsScreen.route) {
            val flightsListScreenViewModel = hiltViewModel<FlightsListScreenViewModel>()
            FlightsListScreen(
                viewModel = flightsListScreenViewModel,
                navController = navController
            )
        }
        composable(Screens.DetailedInfoScreen.route) {

        }
    }
}