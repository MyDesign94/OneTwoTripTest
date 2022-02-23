package com.example.onetwotriptest.presentation.screens.flights_list_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenEvent

@Composable
fun FlightsListScreen(
    viewModel: FlightsListScreenViewModel,
    navController: NavHostController,
) {
    val viewState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(FlightsListScreenEvent.ShowListFlights)
    })
}