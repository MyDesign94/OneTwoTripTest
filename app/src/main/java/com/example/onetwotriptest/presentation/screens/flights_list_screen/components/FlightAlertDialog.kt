package com.example.onetwotriptest.presentation.screens.flights_list_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.onetwotriptest.R
import com.example.onetwotriptest.domain.model.FlightEntitie
import com.example.onetwotriptest.domain.model.PriceEntitie

@Composable
fun FlightAlertDialog(
    modifier: Modifier = Modifier,
    dismissRequest: () -> Unit,
    onConfirm: (PriceEntitie) -> Unit,
    value: FlightEntitie
) {
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(value.prices[0]) }

    AlertDialog(
        onDismissRequest = { dismissRequest() },
        title = {
                TextEx(text = "Test")
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
                            onClick = {
                                onOptionSelected(price)
                            }
                        )
                        TextEx(text = price.type)
                        Spacer(modifier = modifier.weight(1f))
                        TextEx(text = price.amount+ stringResource(id = R.string.RUB))
                    }
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirm(selectedOption)
                }) {
                TextEx(text = stringResource(id = R.string.confirm))
            }
        }
    )
}