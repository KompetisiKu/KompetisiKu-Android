package com.kompetisiku.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val LocalDim = compositionLocalOf { Dimensions() }

private object KompetisiKuRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = Black500

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        Black500,
        lightTheme = true
    )
}

private val LightColorScheme = lightColorScheme(
    primary = Blue500,
    secondary = Orange500,
    tertiary = Orange500,
    secondaryContainer = Blue50,
    onSecondaryContainer = Blue700,
    onSurface = White,
    onSurfaceVariant = Blue50,
    background = Blue50,
    primaryContainer = Blue400,
    error = Red

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun KompetisiKuTheme(
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    dimensions: Dimensions = Dimensions(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            dynamicLightColorScheme(context)
        }

        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            window.navigationBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = {
            CompositionLocalProvider(
                LocalDim provides dimensions,
                LocalRippleTheme provides KompetisiKuRippleTheme
            ) {
                content()
            }
        }
    )
}

object KompetisiKuTheme {
    val dimens: Dimensions
        @Composable
        get() = LocalDim.current
}

val Colors: ColorScheme
    @Composable
    get() = MaterialTheme.colorScheme

val Dimens: Dimensions
    @Composable
    get() = KompetisiKuTheme.dimens
