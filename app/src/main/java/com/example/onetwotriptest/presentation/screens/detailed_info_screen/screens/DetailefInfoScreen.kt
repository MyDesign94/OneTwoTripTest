package com.example.onetwotriptest.presentation.screens.detailed_info_screen.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavDestination
import com.example.onetwotriptest.R
import com.example.onetwotriptest.core.Screens
import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.onetwotriptest.presentation.screens.detailed_info_screen.components.DetailedInfoCard
import com.example.onetwotriptest.presentation.screens.flights_list_screen.components.ButtonWidget
import com.example.onetwotriptest.presentation.screens.widgets.TextEx
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun DetailedInfoScreen(
    modifier: Modifier = Modifier,
    data: FlightEntitie,
    selectedClass: String,
    transplants: Int,
    cost: String,
    padding: Dp = TripTheme.shapes.smallPadding
) {
    Column(
        modifier = modifier.fillMaxSize().padding(padding).padding(bottom = padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            data.trips.forEachIndexed { index, tripEnitie ->
                item {
                    DetailedInfoCard(trip = tripEnitie, flightClass = selectedClass)
                }
                if (transplants != index) {
                    item {
                        TextEx(
                            modifier = modifier
                                .padding(padding)
                                .padding(start = padding),
                            text = stringResource(id = R.string.transplant),
                            textColor = TripTheme.colors.controlColor

                        )
                    }
                }
            }
        }
        Spacer(modifier = modifier.weight(1f))
        ButtonWidget(
            buttonText = String.format(stringArrayResource(id = R.array.buy)[transplants], cost)
        ) {
        }
    }
}