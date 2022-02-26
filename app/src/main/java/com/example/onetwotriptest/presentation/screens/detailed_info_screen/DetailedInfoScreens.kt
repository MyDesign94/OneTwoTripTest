package com.example.onetwotriptest.presentation.screens.detailed_info_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.onetwotriptest.presentation.screens.detailed_info_screen.screens.DetailedInfoScreen
import com.example.onetwotriptest.presentation.screens.detailed_info_screen.state.DetailedInfoViewState

@Composable
fun DetailedInfoScreens(
    viewModel: DetailedInfoViewModel,
) {
    val viewState by viewModel.viewState.collectAsState()

    when (val state = viewState) {
        is DetailedInfoViewState.Loading -> {

        }
        is DetailedInfoViewState.DetailedInfo -> {
            DetailedInfoScreen(
                data = state.flightEntitie,
                selectedClass = state.selectedClass,
                transplants = state.transplants,
                cost = state.cost
            )
        }
    }


}