package com.example.onetwotriptest.domain.interactors

import android.content.Context
import com.example.onetwotriptest.core.toFlightEntitie
import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.onetwotriptest.domain.repository.GetAllFlightsRepository
import com.example.onetwotriptest.domain.use_case.GetAllFlightsUseCase
import com.example.rickandmortapp.feature.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllFlightsInteractor @Inject constructor(
    private val repository: GetAllFlightsRepository,
    private val context: Context,
) : GetAllFlightsUseCase {

    override fun getFlights(): Flow<Resource<List<FlightEntitie>>> = flow {
        emit(Resource.Loading<List<FlightEntitie>>())
        val response = repository.getAllFlights().map { it.toFlightEntitie(context) }
        emit(Resource.Success<List<FlightEntitie>>(response))
    }.catch {
        emit(Resource.Error<List<FlightEntitie>>(it.localizedMessage!!))
    }
}