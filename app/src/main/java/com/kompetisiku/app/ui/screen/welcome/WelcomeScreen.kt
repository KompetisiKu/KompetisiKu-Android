package com.kompetisiku.app.ui.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.components.AppButton
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White
import com.kompetisiku.app.utils.WindowInfo
import com.kompetisiku.app.utils.rememberWindowInfo

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    navigateToOnBoarding: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
    ) {
        val windowInfo = rememberWindowInfo()
        if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
            Image(
                modifier = Modifier
                    .width(300.dp)
                    .align(Alignment.Center)
                    .offset(0.dp, 48.dp),
                painter = painterResource(R.drawable.welcome),
                contentDescription = null
            )
        } else {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .offset(0.dp, 48.dp),
                painter = painterResource(R.drawable.welcome),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier.padding(16.dp, 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                text = stringResource(R.string.title_welcome),
                color = White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(R.string.description_welcome),
                color = White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp, 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            AppButton(
                containerColor = MaterialTheme.colorScheme.secondary,
                text = stringResource(R.string.button_welcome),
                imageVector = Icons.Rounded.ArrowForward,
                large = true,
                fillMaxWidth = false,
                onClick = navigateToOnBoarding
            )
            Text(
                text = stringResource(R.string.link_login),
                color = White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun PreviewWelcomeScreen() {
    KompetisiKuTheme {
        WelcomeScreen(navigateToOnBoarding = { })
    }
}