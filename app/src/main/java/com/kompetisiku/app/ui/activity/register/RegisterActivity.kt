package com.kompetisiku.app.ui.activity.register

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
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.KompetisiKuTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT, Color.TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.light(
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
                    RegisterNavigation(activity = this)
                }
            }
        }
    }
}