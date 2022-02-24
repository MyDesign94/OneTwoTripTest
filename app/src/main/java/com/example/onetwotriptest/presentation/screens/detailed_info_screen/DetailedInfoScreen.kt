package com.example.onetwotriptest.presentation.screens.detailed_info_screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import com.example.onetwotriptest.core.Screens
import com.example.onetwotriptest.presentation.screens.detailed_info_screen.state.DetailedInfoViewState
import com.example.onetwotriptest.presentation.screens.flights_list_screen.components.ButtonWidget
import com.example.onetwotriptest.presentation.screens.flights_list_screen.state.FlightsListScreenViewState

@Composable
fun DetailedInfoScreen(
    modifier: Modifier = Modifier,
    viewModel: DetailedInfoViewModel,
    navController: NavHostController,
    currentDestination: NavDestination?
) {
    val viewState by viewModel.viewState.collectAsState()

    Log.e("QQQ", (viewState as DetailedInfoViewState.DetailedInfo).selectedClass.toString())
    Log.e("QQQ", (viewState as DetailedInfoViewState.DetailedInfo).flightEntitie.toString())
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Tratatata")
    }
}