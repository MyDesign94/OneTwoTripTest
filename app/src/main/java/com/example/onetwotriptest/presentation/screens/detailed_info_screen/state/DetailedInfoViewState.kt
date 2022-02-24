package com.example.onetwotriptest.presentation.screens.detailed_info_screen.state

import com.example.onetwotriptest.domain.model.FlightEntitie

sealed class DetailedInfoViewState {
    data class DetailedInfo(val selectedClass: String? = null, val flightEntitie: FlightEntitie? = null): DetailedInfoViewState()
}
