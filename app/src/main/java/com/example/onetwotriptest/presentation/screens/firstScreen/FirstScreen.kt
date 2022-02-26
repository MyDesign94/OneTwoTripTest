package com.example.onetwotriptest.presentation.screens.firstScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.onetwotriptest.core.Screens
import com.example.onetwotriptest.presentation.screens.widgets.ButtonWidget

@Composable
fun FirstScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ButtonWidget(
            modifier = modifier.fillMaxWidth(0.7f),
            onButtonClick = {
                navController.navigate(
                    Screens.FlightsScreen.route
                )
            }
        )
    }
}