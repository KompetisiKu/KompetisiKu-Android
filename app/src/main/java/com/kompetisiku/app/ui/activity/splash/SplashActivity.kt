package com.kompetisiku.app.ui.activity.splash

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import com.kompetisiku.app.ui.screen.splash.SplashScreen
import com.kompetisiku.app.ui.theme.KompetisiKuTheme

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT, Color.TRANSPARENT
            ),
        )
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            KompetisiKuTheme {
                SplashScreen(activity = this)
            }
        }
    }
}