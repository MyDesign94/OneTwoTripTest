package com.example.onetwotriptest.presentation.ui.theme

import androidx.compose.ui.graphics.Color

val baseLightPalette = TripColors(
    primaryBackground = Color(0xFFFFFFFF),
    primaryText = Color(0xFF3D454C),
    secondaryBackground = Color(0xFFF3F4F5),
    secondaryText = Color(0xFFFFFFFF),
    tintColor = Color.Magenta,
    greenColor = Color(0xFF4CAF50),
    controlColor = Color(0xFF7A8A99),
    errorColor = Color(0xFFFF3377),
    barColor = Color(0xFF191E23)
)

val baseDarkPalette = TripColors(
    primaryBackground = Color(0xFF23282D),
    primaryText = Color(0xDAF2F4F5),
    secondaryBackground = Color(0xFF191E23),
    secondaryText = Color(0xFFFFFFFF),
    tintColor = Color.Magenta,
    greenColor = Color(0xFF4CAF50),
    controlColor = Color(0xFF7A8A99),
    errorColor = Color(0xFFFF6699),
    barColor = Color(0xFF191E23)
)

val purpleLightPalette = baseLightPalette.copy(
    tintColor = Color(0xFFAD57D9)
)

val purpleDarkPalette = baseDarkPalette.copy(
    tintColor = Color(0xFFD580FF)
)

val orangeLightPalette = baseLightPalette.copy(
    tintColor = Color(0xFFFF6619)
)

val orangeDarkPalette = baseDarkPalette.copy(
    tintColor = Color(0xFFFF974D)
)

val blueLightPalette = baseLightPalette.copy(
    tintColor = Color(0xFF4D88FF)
)

val blueDarkPalette = baseDarkPalette.copy(
    tintColor = Color(0xFF99BBFF)
)

val redLightPalette = baseLightPalette.copy(
    tintColor = Color(0xFFE63956)
)

val redDarkPalette = baseDarkPalette.copy(
    tintColor = Color(0xFFFF5975)
)

val greenLightPalette = baseLightPalette.copy(
    tintColor = Color(0xFF12B37D)
)

val greenDarkPalette = baseDarkPalette.copy(
    tintColor = Color(0xFF7EE6C3)
)