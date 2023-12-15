package com.kompetisiku.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val LocalDim = compositionLocalOf { Dimensions() }

private val DarkColorScheme = darkColorScheme(
    primary = Blue500,
    secondary = Orange500,
    tertiary = Orange700,
    secondaryContainer = Blue50,
    onSecondaryContainer = Blue500,
    onSurface = Blue50,
    onSurfaceVariant = Blue50,
    background = Blue50
)

private val LightColorScheme = lightColorScheme(
    primary = Blue500,
    secondary = Orange500,
    tertiary = Orange500,
    secondaryContainer = Blue50,
    onSecondaryContainer = Blue700,
    onSurface = Blue700,
    onSurfaceVariant = Blue50,
    background = Blue50

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
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    dimensions: Dimensions = Dimensions(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = {
            CompositionLocalProvider(LocalDim provides dimensions) {
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

val Dimens: Dimensions
    @Composable
    get() = KompetisiKuTheme.dimens
