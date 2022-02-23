package com.example.onetwotriptest.domain.model

import android.content.Context
import com.example.onetwotriptest.R
import com.example.onetwotriptest.data.remote.dto.Flights
import com.example.onetwotriptest.data.remote.dto.Price

fun Flights.toFlightEntitie(context: Context): FlightEntitie {
    val transferArray = context.resources.getStringArray(R.array.number_of_transfers)
    return FlightEntitie(
        currency = currency,
        chipPrice= prices.minByOrNull { it.amount }!!.amount.toString(),
        transfers = transferArray[trips.size - 1],
        fromTo = "${trips.first().from} - ${trips.last().to}",
        prices = prices.map { it.toPricesEntitie() },
        trips = trips
    )
}

fun Price.toPricesEntitie(): PriceEntitie {
    return PriceEntitie(
        amount = amount.toString(),
        type = type
    )
}


