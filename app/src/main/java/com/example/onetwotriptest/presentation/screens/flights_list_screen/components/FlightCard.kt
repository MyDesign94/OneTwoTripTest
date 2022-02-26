package com.example.onetwotriptest.presentation.screens.flights_list_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.example.onetwotriptest.R
import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.onetwotriptest.domain.model.PriceEntitie
import com.example.onetwotriptest.presentation.screens.widgets.TextEx
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FlightCard(
    modifier: Modifier = Modifier,
    value: FlightEntitie,
    smallPadding: Dp = TripTheme.shapes.smallPadding,
    standardPadding: Dp = TripTheme.shapes.standardPadding,
    backgroundColor: Color = TripTheme.colors.primaryBackground,
    textStyle: TextStyle = TripTheme.typography.heading,
    textColor: Color = TripTheme.colors.tintColor,
    elevation: Dp = TripTheme.shapes.elevation,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    onNavigate: (PriceEntitie) -> Unit
) {
    val infoDialog = remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = smallPadding, bottom = smallPadding),
        backgroundColor = backgroundColor,
        elevation = elevation,
        onClick = { infoDialog.value = true }
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(standardPadding),
            verticalAlignment = verticalAlignment
        ) {
            Column {
                TextEx(text = value.fromTo)
                Spacer(modifier = modifier.height(smallPadding))
                TextEx(text = value.transplant)
            }
            Spacer(modifier = modifier.weight(1f))
            TextEx(
                text = value.chipPrice + stringResource(id = R.string.RUB),
                textColor = textColor,
                style = textStyle
            )
        }
    }
    if (infoDialog.value) {
        FlightAlertDialog(
            value = value,
            dismissRequest = { infoDialog.value = false },
            onConfirm = { onNavigate(it) }
        )
    }

}
