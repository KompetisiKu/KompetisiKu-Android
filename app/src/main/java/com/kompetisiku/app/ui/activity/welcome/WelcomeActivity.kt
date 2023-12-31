package com.kompetisiku.app.ui.activity.welcome

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.kompetisiku.app.ui.screen.welcome.WelcomeScreen
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.KompetisiKuTheme

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT, Color.TRANSPARENT
            )
        )
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            KompetisiKuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Colors.background
                ) {
                    WelcomeScreen(activity = this)
                }
            }
        }
    }
}