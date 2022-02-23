package com.example.onetwotriptest.domain.use_case

import com.example.onetwotriptest.data.remote.dto.Flights
import com.example.rickandmortapp.feature.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetAllFlightsUseCase {

    fun getFlights(): Flow<Resource<List<Flights>>>
}