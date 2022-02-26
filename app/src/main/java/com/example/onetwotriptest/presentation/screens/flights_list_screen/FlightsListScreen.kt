package com.example.onetwotriptest.presentation.screens.flights_list_screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import com.example.onetwotriptest.core.Screens
import com.example.onetwotriptest.domain.model.PriceEntitie
import com.example.onetwotriptest.presentation.screens.flights_list_screen.components.LoadingScreen
import com.example.onetwotriptest.presentation.screens.flights_list_screen.screens.DisplayFlightsScreen
import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenEvent
import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenViewState
import com.google.gson.Gson

@Composable
fun FlightsListScreen(
    viewModel: FlightsListScreenViewModel,
    navController: NavHostController,
    currentDestination: NavDestination?,
) {
    val viewState by viewModel.state.collectAsState()

    when(viewState) {
        is FlightsListScreenViewState.Loading -> {
            LoadingScreen()
        }
        is FlightsListScreenViewState.Display -> {
            Log.e("!!!", (viewState as FlightsListScreenViewState.Display).data.toString())
            DisplayFlightsScreen(
                data = (viewState as FlightsListScreenViewState.Display).data,
                onNavigate = { price, index ->
                    navController.navigate(
                        Screens.DetailedInfoScreen.route +
                                "?chosePrice=${Gson().toJson(price)}" +
                                "&flight=${Gson().toJson((viewState as FlightsListScreenViewState.Display).data[index])}"
                    )
                }
            )
        }
    }
    LaunchedEffect(key1 = viewState, block = {
        viewModel.obtainEvent(FlightsListScreenEvent.ShowListFlights)
    })
}