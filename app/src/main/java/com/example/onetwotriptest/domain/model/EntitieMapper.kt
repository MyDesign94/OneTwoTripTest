package com.example.onetwotriptest.domain.model

import android.content.Context
import com.example.onetwotriptest.R
import com.example.onetwotriptest.data.remote.dto.Flights
import com.example.onetwotriptest.data.remote.dto.Price
import com.example.onetwotriptest.data.remote.dto.Trip
import java.io.BufferedReader
import java.io.InputStreamReader

fun Flights.toFlightEntitie(context: Context): FlightEntitie {
    val transferArray = context.resources.getStringArray(R.array.number_of_transfers)
    return FlightEntitie(
        currency = currency,
        chipPrice= prices.minByOrNull { it.amount }!!.amount.toString(),
        transfers = transferArray[trips.size - 1],
        fromTo = "${trips.first().from} - ${trips.last().to}",
        prices = prices.map { it.toPricesEntitie() },
        trips = trips.map { it.toTripEntitie(context = context) }
    )
}

fun Price.toPricesEntitie(): PriceEntitie {
    return PriceEntitie(
        amount = amount.toString(),
        type = type
    )
}

fun Trip.toTripEntitie(context: Context): TripEnitie {
    val file = context.resources.openRawResource(R.raw.iata)
    val stream = InputStreamReader(file, "utf-8")
    val reader = BufferedReader(stream)
    val listOfIata = mutableListOf<String>()
    var line: String?
    while (run {
            line = reader.readLine()
            line
        } != null) {
        listOfIata.add(line!!)
    }
    return TripEnitie(
        from = from,
        fromLocation = listOfIata.filter { it.contains(from) }.first().split(" — ").last(),
        to = to,
        toLocation = listOfIata.filter { it.contains(to) }.first().split(" — ").last()
    )
}

