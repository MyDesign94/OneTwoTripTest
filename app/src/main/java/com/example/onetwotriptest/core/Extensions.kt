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
    return FlightEntitie(
        currency = currency,
        chipPrice= prices.toChipPrice(context),
        chipPriceWithLuggage = prices.toChipPrice(context, withLuggage = true),
        transplant = trips.size <= 1,
        transplantString = trips.size.toTransplantString(transplantArray),
        fromTo = listOf(
            trips.first().from,
            trips.last().to
        ),
        fromToAirports = listOf(
            listOfIata.parseLocation(trips.first().from).first(),
            listOfIata.parseLocation(trips.last().to).first()),
        fromToLocation = listOf(
            listOfIata.parseLocation(trips.first().from).last(),
            listOfIata.parseLocation(trips.last().to).last()),
        prices = prices.map { it.toPricesEntitie() },
        trips = trips.map { it.toTripEntitie(listOfIata = listOfIata) }
    )
}

private fun Int.toTransplantString(transplantArray: Array<String>): String {
    return when(this) {
        1 -> {
            transplantArray[0]
        }
        2 -> {
            transplantArray[1]
        }
        else -> {
            String.format(transplantArray[2], this)
        }
    }
}


private fun List<Price>.toChipPrice(context: Context, withLuggage: Boolean = false): String {
    return if (this.size > 1) {
        if (withLuggage) {
            context.getString(R.string.from) + (this.minByOrNull { it.amount }!!.amount + 1500).toString()
        } else {
            context.getString(R.string.from) + this.minByOrNull { it.amount }!!.amount.toString()
        }
    } else {
        if (withLuggage) {
            (this.minByOrNull { it.amount }!!.amount + 1500).toString()
        } else {
            this.minByOrNull { it.amount }!!.amount.toString()
        }
    }
}

private fun Price.toPricesEntitie(): PriceEntitie {
    return PriceEntitie(
        amount = amount.toString(),
        type = type
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    )
}

private fun Trip.toTripEntitie(listOfIata: MutableList<String>): TripEnitie {
    return TripEnitie(
        from = from,
        fromLocation = listOfIata.parseLocation(from).last(),
        fromAirport = listOfIata.parseLocation(from).first(),
        to = to,
        toLocation = listOfIata.parseLocation(to).last(),
        toAirport = listOfIata.parseLocation(to).first()
    )
}

private fun MutableList<String>.parseLocation(iata: String): List<String> {
    return this.first { it.contains(iata) }.split(" — ").last().split(",")
}