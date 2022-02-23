package com.example.onetwotriptest.domain.reduse

import com.example.onetwotriptest.domain.use_case.GetAllFlightsUseCase
import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenEvent
import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenViewState
import com.example.rickandmortapp.feature.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FlightsReduce @Inject constructor(
    private val useCase: GetAllFlightsUseCase,
) {

    operator fun invoke(event: FlightsListScreenEvent, currentState: FlightsListScreenViewState):
            Flow<FlightsListScreenViewState> = flow {
        when (event) {
            FlightsListScreenEvent.ShowListFlights -> {
                useCase.getFlights().collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            emit(FlightsListScreenViewState.Display(data = result.data!!))
                        }
                        is Resource.Loading -> {
                            emit(FlightsListScreenViewState.Loading)
                        }
                        is Resource.Error -> {
                            emit(FlightsListScreenViewState.Error(message = result.message!!))
                        }
                    }
                }
            }
        }
    }
}