package com.example.onetwotriptest.presentation.screens.flights_list_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.onetwotriptest.data.remote.dto.Flights
import com.example.onetwotriptest.data.remote.dto.Price
import com.example.onetwotriptest.data.remote.dto.Trip
import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.onetwotriptest.domain.model.PriceEntitie
import com.example.onetwotriptest.presentation.ui.theme.OneTwoTripTestTheme
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun FlightCard(
    modifier: Modifier = Modifier,
    value: FlightEntitie,
    smallPadding: Dp = TripTheme.shapes.smallPadding,
    standardPadding: Dp = TripTheme.shapes.standardPadding,
    backgroundColor: Color = TripTheme.colors.primaryBackground,
    textStyle: TextStyle = TripTheme.typography.heading,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = TripTheme.colors.tintColor,
    elevation: Dp = TripTheme.shapes.elevation,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically

) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = smallPadding, bottom = smallPadding),
        backgroundColor = backgroundColor,
        elevation = elevation
    ) {
        Row(
            modifier = modifier.fillMaxWidth().padding(standardPadding),
            verticalAlignment = verticalAlignment
        ) {
            Column {
                TextEx(text = value.fromTo)
                Spacer(modifier = modifier.height(smallPadding))
                TextEx(text = value.transfers)
            }
            Spacer(modifier = modifier.weight(1f))
            TextEx(
                text = "${value.chipPrice} ${value.currency}",
                textColor = textColor,
                style = textStyle
            )
        }

    }

}

@Preview
@Composable
fun PreviewFlightCard() {
    val price: List<PriceEntitie> = mutableListOf(
        PriceEntitie(
            amount = "49673",
            type = "bussiness"
        ),
        PriceEntitie(
            amount = "29573",
            type = "economy"
        )
    )
    val trips: List<Trip> = mutableListOf(
        Trip(
            from = "SVO",
            to = "HND"
        ),
        Trip(
            from = "NRT",
            to = "EWR"
        )
    )
    OneTwoTripTestTheme {
        FlightCard(value = FlightEntitie(
            currency = "RUB",
            chipPrice = "29573",
            transfers = "1 transfer",
            fromTo = "SVO - EWR",
            prices = price,
            trips = trips
        ))
    }
}