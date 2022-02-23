package com.example.onetwotriptest.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class TripColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val controlColor: Color,
    val errorColor: Color,
)

data class TripTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val toolbar: TextStyle,
    val caption: TextStyle,
)

data class TripShape(
    val standardPadding: Dp,
    val bigPadding: Dp,
    val smallPadding: Dp,
    val elevation: Dp,
    val cornersStyle: Shape,
)

object TripTheme {
    val colors: TripColors
        @Composable
        get() = LocalTripColors.current

    val typography: TripTypography
        @Composable
        get() = LocalTripTypography.current

    val shapes: TripShape
        @Composable
        get() = LocalTripShape.current
}

enum class TripStyle {
    Purple, Orange, Blue, Red, Green
}

enum class TripSize {
    Small, Medium, Big
}

enum class TripCorners {
    Flat, Rounded
}

val LocalTripColors = staticCompositionLocalOf<TripColors> {
    error("No colors provided")
}

val LocalTripTypography = staticCompositionLocalOf<TripTypography> {
    error("No font provided")
}

val LocalTripShape = staticCompositionLocalOf<TripShape> {
    error("No shapes provided")
}