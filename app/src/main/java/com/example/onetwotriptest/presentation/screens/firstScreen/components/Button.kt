package com.example.onetwotriptest.presentation.screens.flights_list_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.onetwotriptest.R
import com.example.onetwotriptest.presentation.ui.theme.OneTwoTripTestTheme
import com.example.onetwotriptest.presentation.ui.theme.RobotoCondensed
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun ButtonWidget(
    modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(TripTheme.colors.tintColor),
    standardSize: Modifier = Modifier.fillMaxWidth(0.7f),
    buttonText: String = stringResource(R.string.search),
    buttonTextStyle: TextStyle = TripTheme.typography.heading,
    textAlign: TextAlign = TextAlign.Center,
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
            textAlign = textAlign
        )
    }
}

@Composable
fun TextEx(
    modifier: Modifier = Modifier,
    text: String = "",
    style: TextStyle = TripTheme.typography.body,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = TripTheme.colors.primaryText,
    fontFamily: FontFamily = RobotoCondensed,
) {
    Text(
        text = text,
        color = textColor,
        style = style,
        fontFamily = fontFamily,
        textAlign = textAlign,
        modifier = modifier
    )
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
