package com.example.onetwotriptest.domain.model

import com.example.onetwotriptest.data.remote.dto.Trip

data class FlightEntitie(
    val currency: String,
    val chipPrice: String,
    val chipPriceWithLuggage: String,
    val transplant: Boolean,
    val transplantString: String,
    val fromTo: List<String>,
    val fromToAirports: List<String>,
    val fromToLocation: List<String>,
    val prices: List<PriceEntitie>,
    val trips: List<TripEnitie>
)

data class PriceEntitie(
    val amount: String,
    val type: String
)

data class TripEnitie(
    val from: String,
    val fromLocation: String,
    val fromAirport: String,
    val to: String,
    val toLocation: String,
    val toAirport: String
)
