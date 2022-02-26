package com.example.onetwotriptest.presentation.screens.flights_list_screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.example.onetwotriptest.core.Screens
import com.example.onetwotriptest.presentation.screens.flights_list_screen.screens.DisplayFlightsScreen
import com.example.onetwotriptest.presentation.screens.flights_list_screen.screens.ErrorScreen
import com.example.onetwotriptest.presentation.screens.flights_list_screen.screens.FlightLoadingScreen
import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenEvent
import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenViewState
import com.google.gson.Gson

@Composable
fun FlightsListScreen(
    viewModel: FlightsListScreenViewModel,
    navController: NavHostController,
) {
    val viewState by viewModel.state.collectAsState()

    when (val state = viewState) {
        is FlightsListScreenViewState.Loading -> {
            FlightLoadingScreen()
        }
        is FlightsListScreenViewState.Display -> {
            Log.e("!!!", state.data.toString())
            DisplayFlightsScreen(
                data = state.data,
                onNavigate = { price, index ->
                    navController.navigate(
                        Screens.DetailedInfoScreen.route +
                                "?chosePrice=${Gson().toJson(price)}" +
                                "&flight=${Gson().toJson(state.data[index])}"
                    )
                }
            )
        }
        is FlightsListScreenViewState.Error -> {
            ErrorScreen(
                message = state.message,
                onRestart = { viewModel.obtainEvent(FlightsListScreenEvent.Refresh) }
            )
        }
    }
    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(FlightsListScreenEvent.ShowListFlights)
    })
}