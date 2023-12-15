package com.kompetisiku.app.ui.activity.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kompetisiku.app.ui.screen.splash.SplashScreen
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KompetisiKuTheme {
                SplashScreen(activity = this)
            }
        }
    }
}