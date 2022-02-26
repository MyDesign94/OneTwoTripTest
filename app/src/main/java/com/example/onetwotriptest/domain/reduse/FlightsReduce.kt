package com.example.onetwotriptest.domain.reduse

import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenEvent
import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenViewState
import kotlinx.coroutines.flow.Flow

interface FlightsReduce {

    fun reduce(event: FlightsListScreenEvent): Flow<FlightsListScreenViewState>
}