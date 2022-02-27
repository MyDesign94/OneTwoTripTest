package com.example.onetwotriptest.presentation.screens.flights_list_screen.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.onetwotriptest.domain.model.PriceEntitie
import com.example.onetwotriptest.presentation.screens.flights_list_screen.components.FlightCard
import com.example.onetwotriptest.presentation.ui.theme.TripTheme
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun DisplayFlightsScreen(
    data: List<FlightEntitie>,
    modifier: Modifier = Modifier,
    standardPadding: Dp = TripTheme.shapes.standardPadding,
    padding: PaddingValues = PaddingValues(10.dp),
    onNavigate: (PriceEntitie, Int) -> Unit,
) {
    val lazyListState = rememberLazyListState()

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = standardPadding, end = standardPadding),
            state = lazyListState,
            flingBehavior = rememberSnapperFlingBehavior(
                lazyListState = lazyListState,
                endContentPadding = padding.calculateBottomPadding()
            ),
            contentPadding = padding,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            itemsIndexed(data) { index, flightEntitie ->
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