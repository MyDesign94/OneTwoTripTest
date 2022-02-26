package com.example.onetwotriptest.presentation

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import com.example.onetwotriptest.presentation.screens.MainScreen
import com.example.onetwotriptest.presentation.ui.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OneTwoTripTestTheme(
                style = TripStyle.Blue,
                textSize = TripSize.Medium,
                corners = TripCorners.Rounded,
                bigPaddingSize = TripSize.Medium,
                standardPaddingSize = TripSize.Medium,
                smallPaddingSize = TripSize.Medium,
                elevationSize = TripSize.Small,
                darkTheme = false
            ) {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = when (this.resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)) {
                            Configuration.UI_MODE_NIGHT_YES -> {
                                blueLightPalette.barColor
                            }
                            Configuration.UI_MODE_NIGHT_NO -> {
                                blueDarkPalette.barColor
                            }
                            else -> {
                                blueDarkPalette.barColor
                            }
                        }
                    )
                }
                MainScreen()
            }
        }
    }
}