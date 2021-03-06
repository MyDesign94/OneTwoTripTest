package com.example.onetwotriptest.presentation.screens.detailed_info_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.onetwotriptest.R
import com.example.onetwotriptest.domain.model.TripEnitie
import com.example.onetwotriptest.presentation.screens.widgets.TextWidget
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun DetailedInfoCard(
    modifier: Modifier = Modifier,
    trip: TripEnitie,
    flightClass: String,
    backgroundColor: Color = TripTheme.colors.primaryBackground,
    padding: Dp = TripTheme.shapes.smallPadding,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(padding),
        backgroundColor = backgroundColor
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(padding)
        ) {
            Row(
                modifier = modifier
                    .padding(padding)
                    .padding(bottom = padding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BorderCard(
                    modifier = modifier,
                    text = stringResource(id = R.string.airline_flight),
                    color = TripTheme.colors.tintColor
                )
                Image(
                    modifier = modifier
                        .height(dimensionResource(id = R.dimen.stars_size))
                        .padding(start = padding),
                    alignment = Alignment.Center,
                    painter = painterResource(id = R.drawable.stars),
                    contentDescription = null
                )
            }

            Divider()
            CardItemRow(airport = trip.fromAirport, iata = trip.from, city = trip.fromLocation)
            CardItemRow(airport = trip.toAirport, iata = trip.to, city = trip.toLocation)
            Divider()
            TextWidget(
                modifier = modifier.padding(padding),
                text = stringResource(id = R.string.airbus) + flightClass,
                style = TripTheme.typography.caption
            )
        }
    }
}

@Composable
fun CardItemRow(
    modifier: Modifier = Modifier,
    airport: String,
    iata: String,
    city: String,
    padding: Dp = TripTheme.shapes.smallPadding,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = padding)
            .padding(padding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            TextWidget(
                text = airport
            )
            TextWidget(
                text = city,
                textColor = TripTheme.colors.controlColor,
                style = TripTheme.typography.caption
            )
        }
        BorderCard(modifier = modifier, text = iata)
    }
}

@Composable
private fun BorderCard(
    modifier: Modifier,
    text: String,
    backgroundColor: Color = TripTheme.colors.primaryBackground,
    color: Color = TripTheme.colors.controlColor,
    padding: Dp = TripTheme.shapes.smallPadding,
    style: TextStyle = TripTheme.typography.caption,
    borderWidth: Dp = 1.dp,
) {
    Card(
        border = BorderStroke(width = borderWidth, color = color),
        backgroundColor = backgroundColor
    ) {
        TextWidget(
            modifier = modifier.padding(start = padding, end = padding),
            text = text,
            textColor = color,
            style = style
        )
    }
}