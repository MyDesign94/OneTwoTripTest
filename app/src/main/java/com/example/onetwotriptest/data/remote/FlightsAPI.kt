package com.example.onetwotriptest.data.remote

import com.example.onetwotriptest.core.Constant.PREFIX
import com.example.onetwotriptest.data.remote.dto.Flights
import retrofit2.http.GET

interface FlightsAPI {

    @GET(PREFIX)
    suspend fun getFlightsDTO(): List<Flights>
}