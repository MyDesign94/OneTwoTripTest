package com.example.onetwotriptest.presentation.screens.flights_list_screen.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.onetwotriptest.domain.model.PriceEntitie
import com.example.onetwotriptest.presentation.screens.flights_list_screen.components.FlightCard
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun DisplayFlightsScreen(
    data: List<FlightEntitie>,
    modifier: Modifier = Modifier,
    padding: Dp = TripTheme.shapes.standardPadding,
    onNavigate: (PriceEntitie, Int) -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = padding, end = padding)
        ) {
            data.forEachIndexed { index, flightEntitie ->
                item {
                    FlightCard(
                        value = flightEntitie,
                        onNavigate = { price ->
                            onNavigate(price, index)
                        }
                    )
                }
            }
        }
    }
}