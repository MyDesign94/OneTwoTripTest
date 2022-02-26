package com.example.onetwotriptest.presentation.screens.detailed_info_screen.state

import com.example.onetwotriptest.domain.model.FlightEntitie

sealed class DetailedInfoViewState {
    data class DetailedInfo(
        val selectedClass: String,
        val cost: String,
        val flightEntitie: FlightEntitie,
        val transplants: Int
    ): DetailedInfoViewState()
    object Loading : DetailedInfoViewState()
}
