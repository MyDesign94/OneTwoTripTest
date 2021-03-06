package com.example.onetwotriptest.domain.use_case

import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.rickandmortapp.feature.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetAllFlightsUseCase {

    fun getFlights(): Flow<Resource<List<FlightEntitie>>>
}