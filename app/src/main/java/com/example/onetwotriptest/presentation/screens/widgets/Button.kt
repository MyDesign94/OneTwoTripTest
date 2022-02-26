package com.example.onetwotriptest.presentation.screens.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.onetwotriptest.R
import com.example.onetwotriptest.presentation.ui.theme.OneTwoTripTestTheme
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun ButtonWidget(
    modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(TripTheme.colors.tintColor),
    standardSize: Modifier = Modifier,
    buttonText: String = stringResource(R.string.search),
    buttonTextStyle: TextStyle = TripTheme.typography.toolbar,
    textAlign: TextAlign = TextAlign.Center,
    textColor: Color = TripTheme.colors.primaryBackground,
    onButtonClick: () -> Unit,
) {
    Button(
        onClick = { onButtonClick() },
        modifier = standardSize,
        colors = buttonColors
    ) {
        TextEx(
            text = buttonText,
            style = buttonTextStyle,
            modifier = modifier.fillMaxWidth(),
            textAlign = textAlign,
            textColor = textColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButton() {
    OneTwoTripTestTheme(
        darkTheme = false
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(TripTheme.colors.primaryBackground),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ButtonWidget(
                onButtonClick = {

                }
            )
        }

    }
}
