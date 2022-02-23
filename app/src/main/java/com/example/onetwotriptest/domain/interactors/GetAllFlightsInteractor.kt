package com.example.onetwotriptest.domain.interactors

import android.content.Context
import android.util.Log
import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.onetwotriptest.domain.model.toFlightEntitie
import com.example.onetwotriptest.domain.repository.GetAllFlightsRepository
import com.example.onetwotriptest.domain.use_case.GetAllFlightsUseCase
import com.example.rickandmortapp.feature.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

class GetAllFlightsInteractor @Inject constructor(
    private val repository: GetAllFlightsRepository,
    private val context: Context,
) : GetAllFlightsUseCase {

    override fun getFlights(): Flow<Resource<List<FlightEntitie>>> = flow {
        emit(Resource.Loading<List<FlightEntitie>>())
        emit(Resource.Success<List<FlightEntitie>>(repository.getAllFlights().map { it.toFlightEntitie(context) }))
    }.catch {
        emit(Resource.Error<List<FlightEntitie>>(it.localizedMessage!!))
    }
}