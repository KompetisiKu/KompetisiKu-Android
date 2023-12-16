package com.kompetisiku.app.ui.screen.welcome

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.activity.onboarding.OnBoardingActivity
import com.kompetisiku.app.ui.components.AppButton
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    activity: ComponentActivity
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Colors.primary),
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .offset(
                    Dimens.offsetX,
                    Dimens.offsetY
                ),
            painter = painterResource(R.drawable.welcome),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .padding(
                    Dimens.paddingHorizontalMedium,
                    Dimens.paddingVerticalLarge
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.spaceLarge)
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
                .padding(
                    Dimens.paddingHorizontalMedium,
                    Dimens.paddingVerticalLarge
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.spaceLarge)
        ) {
            AppButton(
                containerColor = Colors.secondary,
                text = stringResource(R.string.button_welcome),
                imageVector = Icons.Rounded.ArrowForward,
                large = true,
                fillMaxWidth = false,
                onClick = { activity.startActivity(Intent(activity, OnBoardingActivity::class.java)) }
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
        WelcomeScreen(activity = ComponentActivity())
    }
}