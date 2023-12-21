package com.kompetisiku.app.ui.screen.login

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.activity.main.MainActivity
import com.kompetisiku.app.ui.components.AppButton
import com.kompetisiku.app.ui.components.AppTextField
import com.kompetisiku.app.ui.components.FieldContainer
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.Orange600
import com.kompetisiku.app.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    activity: ComponentActivity
) {
    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets(Dimens.paddingDefault),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Colors.primary
                ),
                title = {
                    Text(
                        text = stringResource(R.string.title_register),
                        color = White,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            activity.finish()
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(Dimens.iconLarge),
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = stringResource(R.string.icon_back)
                        )
                    }
                },
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = Dimens.elevationSmall,
                        shape = RectangleShape
                    )
                    .background(White)
                    .navigationBarsPadding()
                    .padding(
                        Dimens.paddingHorizontalMedium,
                        Dimens.paddingVerticalLarge
                    )
            ) {
                AppButton(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = Colors.secondary,
                    borderColor = Orange600,
                    text = stringResource(R.string.button_login),
                    large = true,
                    onClick = {
                        val intent = Intent(activity, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        activity.startActivity(intent)
                        activity.finish()
                    }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.spaceSmall)
        ) {
            FieldContainer(
                label = stringResource(R.string.label_login),
                description = stringResource(R.string.description_login)
            ) {
                AppTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    onValueChange = {},
                    placeholder = stringResource(R.string.email),
                    keyboardType = KeyboardType.Email
                )
                AppTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    onValueChange = {},
                    placeholder = stringResource(R.string.password),
                    keyboardType = KeyboardType.Password
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    KompetisiKuTheme {
        LoginScreen(activity = ComponentActivity())
    }
}