package com.example.onetwotriptest.domain.interactors

import android.content.Context
import android.util.Log
import com.example.onetwotriptest.R
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
        emit(Resource.Loading())
        val response = repository.getAllFlights().map { it.toFlightEntitie(context) }
        emit(Resource.Success(response))
    }.catch {
        Log.e("!!!", it.localizedMessage!!)
        emit(Resource.Error(context.getString(R.string.daily_error_loading)))
    }
}