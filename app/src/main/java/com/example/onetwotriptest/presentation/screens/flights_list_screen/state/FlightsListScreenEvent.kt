package com.example.onetwotriptest.presentation.screens.flights_list_screen.state

sealed class FlightsListScreenEvent {
    object ShowListFlights : FlightsListScreenEvent()
    object Refresh: FlightsListScreenEvent()
}
