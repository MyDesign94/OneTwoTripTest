package com.example.onetwotriptest.core

import androidx.annotation.StringRes
import com.example.onetwotriptest.R

sealed class Screens(
    val route: String,
    @StringRes val resourceId: Int,

    ) {
    object FirstScreen : Screens(
        route = "first_screen",
        resourceId = R.string.first_screen
    )

    object FlightsScreen : Screens(
        route = "flights",
        resourceId = R.string.flights
    )

    object DetailedInfoScreen : Screens(
        route = "detailed_info",
        resourceId = R.string.detailed_info
    )
}
