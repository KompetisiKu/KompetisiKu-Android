package com.kompetisiku.app.ui.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalDim = compositionLocalOf { Dimensions() }

data class Dimensions(
    val paddingHorizontalLarge: Dp = 24.dp,
    val paddingHorizontalMedium: Dp = 16.dp,
    val paddingHorizontalSmall: Dp = 12.dp,
    val paddingVerticalLarge: Dp = 24.dp,
    val paddingVerticalMedium: Dp = 16.dp,
    val paddingVerticalSmall: Dp = 12.dp,
    val buttonPaddingHorizontalMedium: Dp = 24.dp,
    val buttonPaddingVerticalMedium: Dp = 18.dp,
    val buttonPaddingHorizontalSmall: Dp = 18.dp,
    val buttonPaddingVerticalSmall: Dp = 12.dp,
    val spaceLarge: Dp = 24.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceExtra: Dp = 4.dp,
)