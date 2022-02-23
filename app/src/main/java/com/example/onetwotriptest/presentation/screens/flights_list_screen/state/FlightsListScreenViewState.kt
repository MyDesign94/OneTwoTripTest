package com.example.onetwotriptest.presentation.screens.flights_list_screen.state

import com.example.onetwotriptest.data.remote.dto.Flights

sealed class FlightsListScreenViewState {
    object Loading : FlightsListScreenViewState()
    data class Display(val data: List<Flights>) : FlightsListScreenViewState()
    data class Error(val message: String) : FlightsListScreenViewState()
}
