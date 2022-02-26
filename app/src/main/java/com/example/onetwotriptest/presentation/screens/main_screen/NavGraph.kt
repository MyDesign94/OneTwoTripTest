package com.example.onetwotriptest.presentation.screens.main_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.onetwotriptest.core.Screens
import com.example.onetwotriptest.presentation.screens.detailed_info_screen.DetailedInfoScreens
import com.example.onetwotriptest.presentation.screens.detailed_info_screen.DetailedInfoViewModel
import com.example.onetwotriptest.presentation.screens.firstScreen.FirstScreen
import com.example.onetwotriptest.presentation.screens.flights_list_screen.FlightsListScreen
import com.example.onetwotriptest.presentation.screens.flights_list_screen.FlightsListScreenViewModel
import com.example.onetwotriptest.presentation.screens.flights_list_screen.components.TopBarWidget

@Composable
fun NavGraph(
    navController: NavHostController,
    currentDestination: NavDestination?,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = Color.Transparent,
        topBar = {
            TopBarWidget(
                currentDestination = currentDestination,
                onClick = { navController.popBackStack() }
            )
        }
    ) {
        NavHost(navController = navController, startDestination = Screens.FirstScreen.route) {
            composable(Screens.FirstScreen.route) {
                FirstScreen(navController = navController)
            }
            composable(Screens.FlightsScreen.route) {
                val flightsListScreenViewModel = hiltViewModel<FlightsListScreenViewModel>()
                FlightsListScreen(
                    viewModel = flightsListScreenViewModel,
                    navController = navController,
                    currentDestination = currentDestination
                )
            }
            composable(
                route = Screens.DetailedInfoScreen.route + "?chosePrice={chosePrice}&flight={flight}",
                arguments = listOf(
                    navArgument(
                        name = "chosePrice",
                    ) {
                        type = NavType.StringType
                        defaultValue = ""
                    },
                    navArgument(
                        name = "flight"
                    ) {
                        type = NavType.StringType
                        defaultValue = ""
                    }
                )
            ) {
                val detailedInfoViewModel = hiltViewModel<DetailedInfoViewModel>()
                DetailedInfoScreens(
                    viewModel = detailedInfoViewModel
                )
            }
        }
    }

}