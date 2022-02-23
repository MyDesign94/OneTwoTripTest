package com.example.onetwotriptest.domain.interactors

import com.example.onetwotriptest.data.remote.dto.Flights
import com.example.onetwotriptest.domain.repository.GetAllFlightsRepository
import com.example.onetwotriptest.domain.use_case.GetAllFlightsUseCase
import com.example.rickandmortapp.feature.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllFlightsInteractor @Inject constructor(
    private val repository: GetAllFlightsRepository,
) : GetAllFlightsUseCase {

    override fun getFlights(): Flow<Resource<List<Flights>>> = flow {
        emit(Resource.Loading<List<Flights>>())
        emit(Resource.Success<List<Flights>>(repository.getAllFlights()))
    }.catch {
        emit(Resource.Error<List<Flights>>(it.localizedMessage!!))
    }

}