package com.kompetisiku.app.ui.activity.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.kompetisiku.app.ui.screen.onboarding.OnBoardingScreen
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.KompetisiKuTheme

class OnBoardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KompetisiKuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Colors.primary
                ) {
                    OnBoardingScreen(activity = this)
                }
            }
        }
    }
}