package com.example.onetwotriptest.core

import android.content.Context
import com.example.onetwotriptest.R
import com.example.onetwotriptest.data.remote.dto.Flights
import com.example.onetwotriptest.data.remote.dto.Price
import com.example.onetwotriptest.data.remote.dto.Trip
import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.onetwotriptest.domain.model.PriceEntitie
import com.example.onetwotriptest.domain.model.TripEnitie
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun Flights.toFlightEntitie(context: Context): FlightEntitie {
    val transplantArray = context.resources.getStringArray(R.array.number_of_transplants)
    return FlightEntitie(
        currency = currency,
        chipPrice= prices.minByOrNull { it.amount }!!.amount.toString(),
        transplant = transplantArray[trips.size - 1],
        fromTo = "${trips.first().from} - ${trips.last().to}",
        prices = prices.map { it.toPricesEntitie() },
        trips = trips.map { it.toTripEntitie(context = context) }
    )
}

fun Price.toPricesEntitie(): PriceEntitie {
    return PriceEntitie(
        amount = amount.toString(),
        type = type
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
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
        fromLocation = listOfIata.parseLocation(from).last(),
        fromAirport = listOfIata.parseLocation(from).first(),
        to = to,
        toLocation = listOfIata.parseLocation(to).last(),
        toAirport = listOfIata.parseLocation(to).first()
    )
}

fun MutableList<String>.parseLocation(iata: String): List<String> {
    return this.first { it.contains(iata) }.split(" — ").last().split(",")
}