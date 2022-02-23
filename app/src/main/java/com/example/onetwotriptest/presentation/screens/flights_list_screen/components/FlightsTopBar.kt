package com.example.onetwotriptest.presentation.screens.flights_list_screen.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavDestination
import com.example.onetwotriptest.R
import com.example.onetwotriptest.core.Screens
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun FlightsTopBar(
    currentDestination: NavDestination?,
    standardPadding: Dp = TripTheme.shapes.standardPadding,
    bigPadding: Dp = TripTheme.shapes.bigPadding,
    textColor: Color = TripTheme.colors.primaryBackground,
    textStyle: TextStyle = TripTheme.typography.toolbar,
    backgroundColor: Color = TripTheme.colors.tintColor,
    elevation: Dp = TripTheme.shapes.elevation,
    onClick: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.height(dimensionResource(id = R.dimen.barSize)),
        backgroundColor = backgroundColor,
        elevation = elevation,
        title = {
            Text(
                modifier = Modifier.padding(start = bigPadding, top = standardPadding, bottom = standardPadding),
                text = when (currentDestination?.route) {
                    Screens.FlightsScreen.route -> stringResource(id = Screens.FlightsScreen.resourceId)
                    Screens.DetailedInfoScreen.route -> stringResource(id = Screens.DetailedInfoScreen.resourceId)
                    else -> { "" }
                },
                style = textStyle,
                color = textColor
            )
        },
        navigationIcon = {
            IconButton(onClick = { onClick() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        }
    )
}