package com.example.onetwotriptest.presentation.screens.detailed_info_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.onetwotriptest.domain.model.PriceEntitie
import com.example.onetwotriptest.presentation.screens.detailed_info_screen.state.DetailedInfoViewState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailedInfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _viewState = MutableStateFlow<DetailedInfoViewState>(DetailedInfoViewState.Loading)
    val viewState = _viewState.asStateFlow()

    init {
        var chosePrice: PriceEntitie? = null
        var flight: FlightEntitie? = null
        savedStateHandle.get<String>("chosePrice")?.let {
            chosePrice = Gson().fromJson(it, PriceEntitie::class.java)
        }
        savedStateHandle.get<String>("flight")?.let {
            flight = Gson().fromJson(it, FlightEntitie::class.java)
        }
        viewModelScope.launch(Dispatchers.Default) {
            _viewState.value =  DetailedInfoViewState.DetailedInfo(
                selectedClass = chosePrice?.type!!,
                cost = chosePrice?.amount!!,
                flightEntitie = flight!!,
                transplants = flight?.trips?.size!! - 1,
            )
        }
    }

}