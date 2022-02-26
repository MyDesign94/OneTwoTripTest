package com.example.onetwotriptest.presentation.screens.widgets

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.onetwotriptest.presentation.ui.theme.RobotoCondensed
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun TextWidget(
    modifier: Modifier = Modifier,
    text: String = "",
    style: TextStyle = TripTheme.typography.body,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = TripTheme.colors.primaryText,
    fontFamily: FontFamily = RobotoCondensed,
    textWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = text,
        color = textColor,
        style = style,
        fontFamily = fontFamily,
        textAlign = textAlign,
        modifier = modifier,
        fontWeight = textWeight
    )
}