package com.example.onetwotriptest.presentation.screens.detailed_info_screen.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.example.onetwotriptest.R
import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.onetwotriptest.presentation.screens.detailed_info_screen.components.DetailedInfoCard
import com.example.onetwotriptest.presentation.screens.widgets.ButtonWidget
import com.example.onetwotriptest.presentation.screens.widgets.TextWidget
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun DetailedInfoScreen(
    modifier: Modifier = Modifier,
    data: FlightEntitie,
    selectedClass: String,
    transplants: Int,
    cost: String,
    smallPadding: Dp = TripTheme.shapes.smallPadding,
    standardPadding: Dp = TripTheme.shapes.standardPadding,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(smallPadding)
            .padding(bottom = smallPadding),
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
                        TextWidget(
                            modifier = modifier
                                .padding(smallPadding)
                                .padding(start = smallPadding),
                            text = stringResource(id = R.string.transplant),
                            textColor = TripTheme.colors.controlColor

                        )
                    }
                }
            }
        }
        Spacer(modifier = modifier.weight(1f))
    }
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .background(TripTheme.colors.secondaryBackground),
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(standardPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextWidget(
                    modifier = modifier.padding(bottom = smallPadding),
                    text = String.format(stringArrayResource(id = R.array.buy)[transplants], cost),
                    style = TripTheme.typography.toolbar
                )
                ButtonWidget(
                    modifier = modifier.fillMaxWidth(1f),
                    buttonText = stringResource(id = R.string.select)
                ) {
                }
            }
        }
    }
}