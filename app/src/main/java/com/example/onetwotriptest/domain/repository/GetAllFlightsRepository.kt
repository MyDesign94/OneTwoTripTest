package com.example.onetwotriptest.domain.repository

import com.example.onetwotriptest.data.remote.dto.Flights

interface GetAllFlightsRepository {

    suspend fun getAllFlights(): List<Flights>
}