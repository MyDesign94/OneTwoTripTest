package com.example.onetwotriptest.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OneTwoTripTestTheme(
    style: TripStyle = TripStyle.Purple,
    textSize: TripSize = TripSize.Medium,
    elevationSize: TripSize = TripSize.Medium,
    standardPaddingSize: TripSize = TripSize.Medium,
    bigPaddingSize: TripSize = TripSize.Medium,
    smallPaddingSize: TripSize = TripSize.Medium,
    corners: TripCorners = TripCorners.Rounded,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = when (darkTheme) {
        true -> {
            when (style) {
                TripStyle.Purple -> purpleDarkPalette
                TripStyle.Blue -> blueDarkPalette
                TripStyle.Orange -> orangeDarkPalette
                TripStyle.Red -> redDarkPalette
                TripStyle.Green -> greenDarkPalette
            }
        }
        false -> {
            when (style) {
                TripStyle.Purple -> purpleLightPalette
                TripStyle.Blue -> blueLightPalette
                TripStyle.Orange -> orangeLightPalette
                TripStyle.Red -> redLightPalette
                TripStyle.Green -> greenLightPalette
            }
        }
    }

    val typography = TripTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                TripSize.Small -> 24.sp
                TripSize.Medium -> 28.sp
                TripSize.Big -> 32.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontSize = when (textSize) {
                TripSize.Small -> 14.sp
                TripSize.Medium -> 16.sp
                TripSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        toolbar = TextStyle(
            fontSize = when (textSize) {
                TripSize.Small -> 14.sp
                TripSize.Medium -> 16.sp
                TripSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Medium
        ),
        caption = TextStyle(
            fontSize = when (textSize) {
                TripSize.Small -> 10.sp
                TripSize.Medium -> 12.sp
                TripSize.Big -> 14.sp
            }
        )
    )

    val shapes = TripShape(
        bigPadding = when (bigPaddingSize) {
            TripSize.Small -> 20.dp
            TripSize.Medium -> 24.dp
            TripSize.Big -> 28.dp
        },
        standardPadding = when (standardPaddingSize) {
            TripSize.Small -> 12.dp
            TripSize.Medium -> 16.dp
            TripSize.Big -> 20.dp
        },
        smallPadding = when (smallPaddingSize) {
            TripSize.Small -> 3.dp
            TripSize.Medium -> 6.dp
            TripSize.Big -> 9.dp
        },
        elevation = when (elevationSize) {
            TripSize.Small -> 2.dp
            TripSize.Medium -> 4.dp
            TripSize.Big -> 6.dp
        },
        cornersStyle = when (corners) {
            TripCorners.Flat -> RoundedCornerShape(0.dp)
            TripCorners.Rounded -> RoundedCornerShape(8.dp)
        }
    )

    CompositionLocalProvider(
        LocalTripColors provides colors,
        LocalTripTypography provides typography,
        LocalTripShape provides shapes,
        content = content
    )
}