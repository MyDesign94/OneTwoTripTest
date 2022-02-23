package com.example.onetwotriptest.data.repository

import com.example.onetwotriptest.data.remote.FlightsAPI
import com.example.onetwotriptest.data.remote.dto.Flights
import com.example.onetwotriptest.domain.repository.GetAllFlightsRepository
import javax.inject.Inject

class GetAllFlightsRepositoryImpl @Inject constructor(
    private val api: FlightsAPI
) : GetAllFlightsRepository {

    override suspend fun getAllFlights(): List<Flights> {
        return api.getFlightsDTO()
    }
}