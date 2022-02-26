package com.example.onetwotriptest.presentation.screens.detailed_info_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import com.example.onetwotriptest.presentation.screens.detailed_info_screen.components.DetailedInfoCard
import com.example.onetwotriptest.presentation.screens.detailed_info_screen.screens.DetailedInfoScreen
import com.example.onetwotriptest.presentation.screens.detailed_info_screen.state.DetailedInfoViewState
import com.example.onetwotriptest.presentation.screens.flights_list_screen.components.ButtonWidget
import com.example.onetwotriptest.presentation.screens.flights_list_screen.components.TopBarWidget
import com.example.onetwotriptest.presentation.screens.flights_list_screen.screens.DisplayFlightsScreen
import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenViewState

@Composable
fun DetailedInfoScreens(
    viewModel: DetailedInfoViewModel,
) {
    val viewState by viewModel.viewState.collectAsState()

    when(val state = viewState) {
        is DetailedInfoViewState.Loading -> {

        }
        is DetailedInfoViewState.DetailedInfo -> {
            DetailedInfoScreen(
                data = state.flightEntitie,
                selectedClass = state.selectedClass,
                transplants = state.transplants,
                cost = state.cost
            )
        }
    }


}