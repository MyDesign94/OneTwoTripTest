package com.example.onetwotriptest.presentation.screens.flights_list_screen.state

import com.example.onetwotriptest.domain.model.FlightEntitie

sealed class FlightsListScreenViewState {
    object Loading : FlightsListScreenViewState()
    data class Display(val data: List<FlightEntitie>) : FlightsListScreenViewState()
    data class Error(val message: String) : FlightsListScreenViewState()
}
