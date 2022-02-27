package com.example.onetwotriptest.presentation.screens.flights_list_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.AlertDialog
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.onetwotriptest.R
import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.onetwotriptest.domain.model.PriceEntitie
import com.example.onetwotriptest.presentation.screens.widgets.ButtonWidget
import com.example.onetwotriptest.presentation.screens.widgets.TextWidget
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun FlightAlertDialog(
    modifier: Modifier = Modifier,
    dismissRequest: () -> Unit,
    onConfirm: (PriceEntitie) -> Unit,
    value: FlightEntitie,
) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(value.prices[0]) }

    AlertDialog(
        onDismissRequest = { dismissRequest() },
        backgroundColor = TripTheme.colors.primaryBackground,
        title = {
            TextWidget(
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth(),
                style = TripTheme.typography.toolbar,
                text = stringResource(id = R.string.select_flight_class),
                textColor = TripTheme.colors.primaryText
            )
        },
        text = {
            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                value.prices.forEach { price ->
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (price.type == selectedOption.type),
                                onClick = { onOptionSelected(price) }
                            ),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (price.type == selectedOption.type),
                            colors = RadioButtonDefaults.colors(
                                selectedColor = TripTheme.colors.tintColor,
                                unselectedColor = TripTheme.colors.controlColor
                            ),
                            onClick = {
                                onOptionSelected(price)
                            }
                        )
                        TextWidget(text = price.type)
                        Spacer(modifier = modifier.weight(1f))
                        TextWidget(text = price.amount + stringResource(id = R.string.RUB))
                    }
                }
            }
        },
        confirmButton = {
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonWidget(
                    buttonText = stringResource(id = R.string.confirm)
                ) {
                    onConfirm(selectedOption)
                }
            }
        }
    )
}