package com.example.onetwotriptest.presentation.screens.flights_list_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    textStyle: TextStyle = TripTheme.typography.toolbar,
    tinitTextColor: Color = TripTheme.colors.tintColor,
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
        Column(
            modifier = modifier.fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(TripTheme.colors.tintColor),
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = smallPadding,
                            bottom = smallPadding,
                            start = standardPadding,
                            end = standardPadding),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column() {
                        TextEx(
                            text = stringResource(id = R.string.airline_company),
                            style = TripTheme.typography.toolbar,
                            textColor = TripTheme.colors.primaryBackground
                        )
                        Image(
                            modifier = modifier
                                .height(dimensionResource(id = R.dimen.stars_size)),
                            alignment = Alignment.TopStart,
                            painter = painterResource(id = R.drawable.stars),
                            contentDescription = null
                        )
                    }
                    TextEx(
                        text = value.chipPrice + stringResource(id = R.string.RUB),
                        textColor = TripTheme.colors.primaryBackground,
                        style = textStyle
                    )
                }

            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = smallPadding,
                        bottom = smallPadding,
                        start = standardPadding,
                        end = standardPadding),
                verticalAlignment = verticalAlignment
            ) {
                Column {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = modifier.weight(2f),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            ColumnFromTo(
                                iata = value.fromTo.first(),
                                airport = value.fromToAirports.first()
                            )
                            TextEx( text = stringResource(id = R.string.arrow_right))
                            ColumnFromTo(
                                iata = value.fromTo.last(),
                                airport = value.fromToAirports.last()
                            )
                        }
                        TextEx(
                            textAlign = TextAlign.End,
                            modifier = modifier.weight(1f),
                            text = value.transplantString,
                            textColor = if (value.transplant) TripTheme.colors.greenColor else TripTheme.colors.controlColor
                        )
                    }
                    CardRow(
                        startText = stringResource(id = R.string.hand_luggage),
                        endText = stringResource(id = R.string.included)
                    )
                    CardRow(
                        startText = stringResource(id = R.string.luggage),
                        endText = stringResource(id = R.string.not_included)
                    )
                    Divider(modifier = modifier.padding(top = smallPadding))
                    CardRow(
                        startText = stringResource(id = R.string.with_luggage),
                        endText = value.chipPriceWithLuggage + stringResource(id = R.string.RUB),
                        endTextColor = tinitTextColor
                    )
                }

            }
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

@Composable
fun ColumnFromTo(
    modifier: Modifier = Modifier,
    iata: String,
    airport: String
) {
    Column(
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        TextEx(
            text = airport,
            textAlign = TextAlign.Center,
            textWeight = FontWeight.Bold
        )
        TextEx(
            text = iata,
            textColor = TripTheme.colors.controlColor
        )
    }
}

@Composable
fun CardRow(
    modifier: Modifier = Modifier,
    startText: String,
    endText: String,
    endTextColor: Color = TripTheme.colors.primaryText,
    padding: Dp = TripTheme.shapes.smallPadding
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = padding, end = padding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        TextEx(text = startText)
        TextEx(text = endText, textColor = endTextColor)
    }
}
