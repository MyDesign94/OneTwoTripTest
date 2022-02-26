package com.example.onetwotriptest.presentation.screens.flights_list_screen.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.example.onetwotriptest.R
import com.example.onetwotriptest.presentation.screens.widgets.TextWidget
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun FlightLoadingScreen(
    modifier: Modifier = Modifier,
    arrangement: Arrangement.Vertical = Arrangement.Top,
    alignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    progressIndicatorColor: Color = TripTheme.colors.controlColor,
    paddingValues: Dp = TripTheme.shapes.bigPadding,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = arrangement,
        horizontalAlignment = alignment
    ) {
        Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.big_spacer)))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = paddingValues),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularProgressIndicator(
                modifier = modifier.size(dimensionResource(id = R.dimen.indicatorSize)),
                color = progressIndicatorColor,
                strokeWidth = dimensionResource(id = R.dimen.indicatorWeight)
            )
            Spacer(modifier = modifier.width(paddingValues))
            TextWidget(
                text = stringResource(id = R.string.loading_text),
                textColor = progressIndicatorColor
            )
        }
    }
}