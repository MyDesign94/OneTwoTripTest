package com.example.onetwotriptest.presentation.screens.flights_list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onetwotriptest.domain.reduse.FlightsReduce
import com.example.onetwotriptest.domain.reduse.FlightsReduceImpl
import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenEvent
import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenViewState
import com.example.rickandmortapp.feature.domain.util.EventHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class  FlightsListScreenViewModel @Inject constructor(
    private val reduce: FlightsReduce,
) : ViewModel(), EventHandler<FlightsListScreenEvent> {

    private val _state: MutableStateFlow<FlightsListScreenViewState> =
        MutableStateFlow(FlightsListScreenViewState.Loading)
    val state = _state.asStateFlow()

    override fun obtainEvent(event: FlightsListScreenEvent) {
        when (_state.value) {
            FlightsListScreenViewState.Loading -> {
                viewModelScope.launch(Dispatchers.Default) {
                    reduce.reduce(event).collect {
                        _state.value = it
                    }
                }
            }
        }
    }
}