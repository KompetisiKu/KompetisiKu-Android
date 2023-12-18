package com.kompetisiku.app.ui.screen.splash

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.activity.welcome.WelcomeActivity
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    activity: ComponentActivity
) {
    LaunchedEffect(true) {
        delay(2000)
        activity.startActivity(Intent(activity, WelcomeActivity::class.java))
        activity.finish()
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Colors.primary),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.splash),
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    KompetisiKuTheme {
        SplashScreen(activity = ComponentActivity())
    }
}