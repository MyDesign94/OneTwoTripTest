package com.example.onetwotriptest.presentation.screens.flights_list_screen.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.onetwotriptest.R
import com.example.onetwotriptest.presentation.screens.widgets.ButtonWidget
import com.example.onetwotriptest.presentation.screens.widgets.TextWidget
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun ErrorScreen(
    message: String,
    modifier: Modifier = Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    contentColor: Color = TripTheme.colors.errorColor,
    textAlign: TextAlign = TextAlign.Center,
    onRestart: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = verticalArrangement
        ) {
            Icon(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.icon_size))
                    .align(horizontalAlignment),
                imageVector = Icons.Filled.Error,
                tint = contentColor,
                contentDescription = null
            )
            Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.standard_spacer)))
            TextWidget(
                text = message,
                textAlign = textAlign
            )
            Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.standard_spacer)))
            ButtonWidget(
                modifier = modifier.fillMaxWidth(0.7f),
                buttonColors = ButtonDefaults.buttonColors(contentColor),
                buttonText = stringResource(id = R.string.refresh),
                onButtonClick = { onRestart() }
            )
        }
    }
}